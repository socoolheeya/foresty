package com.foresty.domain.exposed.model.note.tables

import com.foresty.domain.common.tables.BaseTable
import com.foresty.domain.enums.NoteEnum
import com.foresty.domain.exposed.model.user.tables.Users
import org.jetbrains.exposed.sql.Column


object Notes: BaseTable(name = "note") {
    val title: Column<String?> = varchar(name = "title", length = 255).nullable()
    val star: Column<NoteEnum.Star?> = customEnumeration(
        name = "star",
        sql = "ENUM('STAR1', 'STAR2', 'STAR3', 'STAR4', 'STAR5')",
        fromDb = { value -> NoteEnum.Star.from(value as String) as NoteEnum.Star },
        toDb =  { value -> NoteEnum.Star.entries.find{ it == value }?.code as Any }
    ).nullable()
    val user = reference("user", Users.id)
}
