package com.foresty.domain.exposed.model.note.dao

import com.foresty.domain.exposed.model.note.tables.Notes
import com.foresty.domain.exposed.model.user.dao.UserDao
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class NoteDao(id: EntityID<Long>): LongEntity(id) {
    companion object: LongEntityClass<NoteDao>(Notes)
    var title by Notes.title
    var star by Notes.star
    var user by UserDao referencedOn Notes.user
}