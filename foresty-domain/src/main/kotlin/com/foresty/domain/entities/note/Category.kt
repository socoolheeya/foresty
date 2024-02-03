package com.foresty.domain.entities.note

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigInteger

@Entity
@Table(name = "T_CATEGORY")
class Category(
    @Id
    val id: BigInteger,
    val name: String
)