package com.foresty.domain.entities.common

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime


abstract class BaseTimeEntity(
    @CreatedDate

    val createdDate: LocalDateTime,

    @LastModifiedDate
    val updatedDate: LocalDateTime
)