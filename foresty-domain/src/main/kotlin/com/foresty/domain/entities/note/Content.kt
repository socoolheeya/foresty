package com.foresty.domain.entities.note

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigInteger

@Entity
@Table(name = "T_CONTENT")
class Content(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: BigInteger,
    val nose: String,
    val taste: String,
    val finish: String
)