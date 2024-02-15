package com.foresty.domain.entities.note.dao

import com.foresty.domain.entities.note.tables.Categories
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class CategoryDao(id: EntityID<Long>) : LongEntity(id) {
    companion object: LongEntityClass<CategoryDao>(Categories)
    var name by Categories.name
    var content by ContentDao referencedOn Categories.content

}

