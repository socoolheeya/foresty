package com.foresty.domain.common.tables

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

open class BaseTable(name: String) : LongIdTable(name) {
    val createdBy: Column<String?> = varchar(name = "createdBy", length = 500).nullable()
    val createdDate: Column<java.time.LocalDateTime> = datetime(name = "createdDate")
        .default(LocalDateTime.ofInstant(Instant.now(), ZoneId.of("UTC")))
    val updatedBy: Column<String?> = varchar(name = "updatedBy", length = 500).nullable()
    val updatedDate: Column<java.time.LocalDateTime> = datetime(name = "updatedDate")
        .default(LocalDateTime.ofInstant(Instant.now(), ZoneId.of("UTC")))
}