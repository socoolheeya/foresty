package com.foresty.domain.entities.note.dao

import com.foresty.domain.entities.note.Notes
import com.foresty.domain.entities.user.domain.User
import lombok.ToString
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

@ToString
class Note(id: EntityID<Long>): LongEntity(id) {
    companion object: LongEntityClass<Note>(Notes)
    val title by Notes.title
    val star by Notes.star
    val user by User referencedOn Notes.user
}