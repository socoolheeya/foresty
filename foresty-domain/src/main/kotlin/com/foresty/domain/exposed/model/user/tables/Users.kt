package com.foresty.domain.exposed.model.user.tables

import com.foresty.domain.common.tables.BaseTable


object Users: BaseTable(name = "user") {
    val name = varchar(name = "name", length = 255).nullable()
    val nickName = varchar(name = "nickname", length = 500).nullable()
    val password = varchar(name = "password", length = 500).nullable()
    val email = varchar(name = "email", length = 500).nullable()
}