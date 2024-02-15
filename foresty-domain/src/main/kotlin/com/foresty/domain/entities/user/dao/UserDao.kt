package com.foresty.domain.entities.user.dao

import com.foresty.domain.entities.user.domain.User
import com.foresty.domain.entities.user.tables.Users
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID


class UserDao(id: EntityID<Long>): LongEntity(id) {
    companion object: LongEntityClass<UserDao>(Users)
    var name by Users.name
    var password by Users.password
    var email by Users.email

    fun toDomain(): User {
        return User(id.value, name, password, email)
    }
}
