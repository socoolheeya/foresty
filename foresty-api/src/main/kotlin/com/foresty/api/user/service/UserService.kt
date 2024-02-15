package com.foresty.api.user.service

import com.foresty.domain.entities.user.dao.UserDao
import com.foresty.domain.entities.user.domain.User
import com.foresty.domain.entities.user.tables.Users
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.reactive.function.client.WebClient

@Service
@Transactional(readOnly = true)
class UserService(private val webClient: WebClient) {


    @Transactional
    suspend fun getUserAll(): List<User>? =
        transaction {
            UserDao.all().map { user ->
                User(user.id.value, user.name, user.password, user.email)
            }
        }

    suspend fun getUser(id: Long): User? =
        transaction {
            UserDao.findById(id)?.toDomain()
        }

    suspend fun registerUser(user: User): User {
        return transaction {
            val insertedId = Users.insertAndGetId {
                it[name] = user.name
                it[password] = user.password
                it[email] = user.email
            }
            UserDao[insertedId].toDomain()
        }
    }

    suspend fun modifyUser(user: User): User? =
        UserDao.findById(user.id)?.apply {
            transaction {
                name = user.name
                email = user.email
            }
        }?.toDomain()

    suspend fun deleteUser(id: Long) {
        UserDao.findById(id)?.delete()
    }
}