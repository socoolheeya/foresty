package com.foresty.domain.common.dao

import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.EntityID
import java.time.LocalDateTime

open class BaseDao(id: EntityID<Long>): LongEntity(id) {
    var createdBy: String? = null
    var createdDate: LocalDateTime? = null
    var updatedBy: String? = null
    var updatedDate: LocalDateTime? = null
}