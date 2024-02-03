package com.foresty.domain.entities.common

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity(
    @CreatedBy
    @Column(updatable = false)
    val createdBy: String,
    @LastModifiedBy
    val updatedBy: String,
    createdDate: LocalDateTime,
    updatedDate: LocalDateTime
): BaseTimeEntity(createdDate, updatedDate)