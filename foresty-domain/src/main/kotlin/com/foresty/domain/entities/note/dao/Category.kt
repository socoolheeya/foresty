package com.foresty.domain.entities.note.dao

import com.foresty.domain.entities.note.tables.Categories
import lombok.ToString
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.springframework.stereotype.Repository

@ToString
@Repository
class Category(id: EntityID<Long>) : LongEntity(id) {
    companion object: LongEntityClass<Category>(Categories)
    var name by Categories.name
    val content by Content referencedOn Categories.content

}

