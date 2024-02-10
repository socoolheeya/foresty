package com.foresty.domain.entities.note.tables

import org.jetbrains.exposed.dao.id.LongIdTable


object Contents: LongIdTable(name = "content") {
    val nose = varchar(name = "nose", length = 2000).nullable()
    val taste = varchar(name = "taste", length = 2000).nullable()
    val finish = varchar(name = "finish", length = 2000).nullable()
    val note = reference("note", Notes)
}