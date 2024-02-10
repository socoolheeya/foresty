package com.foresty.domain.entities.note.tables

import org.jetbrains.exposed.dao.id.LongIdTable


object Categories: LongIdTable(name = "category") {
    val name = varchar("name", length = 255).nullable()
    val content = reference("content", Contents)
}