package com.foresty.domain.entities.user.tables

import org.jetbrains.exposed.dao.id.LongIdTable


object Users: LongIdTable(name = "user") {
    val name = varchar(name = "name", length = 255)
    val password = varchar(name = "password", length = 500)
    val email = varchar(name = "email", length = 500)
}