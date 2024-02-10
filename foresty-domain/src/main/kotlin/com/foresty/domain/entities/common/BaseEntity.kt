package com.foresty.domain.entities.common

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.LastModifiedBy
import java.time.LocalDateTime


abstract class BaseEntity(
    @CreatedBy
    val createdBy: String,
    @LastModifiedBy
    val updatedBy: String,
    createdDate: LocalDateTime,
    updatedDate: LocalDateTime
): BaseTimeEntity(createdDate, updatedDate)