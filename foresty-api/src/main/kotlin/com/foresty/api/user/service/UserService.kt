package com.foresty.api.user.service

import com.foresty.api.commons.utils.DateUtils
import com.foresty.domain.exposed.model.user.dao.UserDao
import com.foresty.domain.exposed.model.user.domain.User
import com.foresty.domain.exposed.model.user.tables.Users
import com.foresty.domain.jpa.repository.UserJpaRepository
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.reactive.function.client.WebClient

@Service
@Transactional(readOnly = true)
class UserService(
    private val userJpaRepository: UserJpaRepository
) {

    @Transactional
    suspend fun getUserAllForJpa(): List<User> =
        userJpaRepository.findAll().map { user -> User(
            user.id,
            user.name,
            user.email,
            user.nickName,
            user.createdBy,
            user.createdDate,
            user.updatedBy,
            user.updatedDate
        )}


    @Transactional
    suspend fun getUserAll(): List<User>? =
        transaction {
            UserDao.all().map { user ->
                User(user.id.value, user.name, user.password, user.email, user.createdBy, user.createdDate, user.updatedBy, user.updatedDate)
            }
        }

    suspend fun getUser(id: Long): User? =
        transaction {
            UserDao.findById(id)?.toDomain()
        }

    suspend fun registerUser(user: User): User {
        return transaction {
            val insertedId = Users.insertAndGetId {
                it[name] = user.name.let { it.toString() }
                it[nickName] = user.nickName
                it[email] = user.email
                it[createdBy] = "wonhee.lee"
                it[createdDate] = DateUtils.javaNow()
            }
            UserDao[insertedId].toDomain()
        }
    }

    suspend fun modifyUser(user: User): User? =
        UserDao.findById(user.id)?.apply {
            transaction {
                name = user.name
                email = user.email
                updatedBy = "wonhee.lee"
                updatedDate = DateUtils.javaNow()
            }
        }?.toDomain()

    suspend fun deleteUser(id: Long) {
        UserDao.findById(id)?.delete()
    }
}