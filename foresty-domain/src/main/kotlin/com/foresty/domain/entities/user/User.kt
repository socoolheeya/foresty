package com.foresty.domain.entities.user

import com.foresty.domain.entities.common.BaseEntity
import com.foresty.domain.entities.note.Note
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.math.BigInteger
import java.time.LocalDateTime


@Entity
@Table(name = "T_USER")
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    val id: BigInteger,
    val name: String,
    val email: String,
    val password: String,

    @OneToMany(mappedBy = "user")
    val notes: List<Note> = ArrayList(),
    createdBy: String,
    updatedBy: String,
    createdDate: LocalDateTime,
    updatedDate: LocalDateTime
): BaseEntity(
    createdBy,
    updatedBy,
    createdDate,
    updatedDate
)
