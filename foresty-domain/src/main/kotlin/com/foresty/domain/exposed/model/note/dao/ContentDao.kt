package com.foresty.domain.exposed.model.note.dao

import com.foresty.domain.exposed.model.note.tables.Contents
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class ContentDao(id: EntityID<Long>): LongEntity(id) {
    companion object: LongEntityClass<ContentDao>(Contents)
    var nose by Contents.nose
    var taste by Contents.taste
    var finish by Contents.finish
    var note by NoteDao referencedOn Contents.note
}
