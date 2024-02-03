package com.foresty.domain.entities.note

import com.foresty.domain.entities.user.User
import com.foresty.domain.enums.NoteEnum
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.math.BigInteger

@Entity
@Table(name = "T_NOTE")
class Note(
    @Id
    val id: BigInteger,
    val title: String,
    val content: String,
    val star: NoteEnum.Star,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User
)
