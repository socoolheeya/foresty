package com.foresty.domain.entities.user.domain

import com.foresty.domain.entities.user.tables.Users
import lombok.ToString
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.springframework.stereotype.Repository

@ToString
@Repository
class User(id: EntityID<Long>): LongEntity(id) {
    companion object: LongEntityClass<User>(Users)
    var name by Users.name
    var password by Users.password
    var email by Users.email
}
