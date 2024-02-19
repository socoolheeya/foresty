package com.foresty.domain.exposed.model.user.dao

import com.foresty.domain.common.dao.BaseDao
import com.foresty.domain.exposed.model.user.domain.User
import com.foresty.domain.exposed.model.user.tables.Users
import com.foresty.domain.exposed.model.user.tables.Users.nullable
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID


class UserDao(id: EntityID<Long>): BaseDao(id) {
    companion object: LongEntityClass<UserDao>(Users)
    var name by Users.name
    var nickName by Users.nickName
    var password by Users.password
    var email by Users.email

    fun toDomain(): User {
        return User(
            id = id.value,
            name = name,
            email = email,
            nickName = nickName,
            createdBy =  createdBy,
            createdDate = createdDate,
            updatedBy = updatedBy,
            updatedDate = updatedDate
        )
    }
}
