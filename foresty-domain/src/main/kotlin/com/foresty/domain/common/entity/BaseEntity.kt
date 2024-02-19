package com.foresty.domain.common.entity

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity {
    @CreatedBy
    @Column(name = "createdby")
    val createdBy: String? = null

    @CreatedDate
    @Column(name = "createddate")
    val createdDate: LocalDateTime? = null

    @LastModifiedBy
    @Column(name = "updatedby", updatable = false)
    val updatedBy: String? = null

    @LastModifiedDate
    @Column(name = "updateddate", updatable = false)
    val updatedDate: LocalDateTime? = null
}
