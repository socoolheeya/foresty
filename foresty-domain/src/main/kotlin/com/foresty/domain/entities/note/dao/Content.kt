package com.foresty.domain.entities.note.dao

import com.foresty.domain.entities.note.tables.Contents
import lombok.ToString
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.springframework.stereotype.Repository

@ToString
@Repository
class Content(id: EntityID<Long>): LongEntity(id) {
    companion object: LongEntityClass<Content>(Contents)
    val nose by Contents.nose
    val taste by Contents.taste
    val finish by Contents.finish
    val note by Note referencedOn Contents.note
}
