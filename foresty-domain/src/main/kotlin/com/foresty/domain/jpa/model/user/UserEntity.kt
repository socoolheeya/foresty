package com.foresty.domain.jpa.model.user

import com.foresty.domain.common.entity.BaseEntity
import com.foresty.domain.exposed.model.user.domain.User
import com.foresty.domain.jpa.model.note.NoteEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "user")
class UserEntity(
    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column
    var name: String,

    @Column(name = "nickName")
    var nickName: String?,

    @Column
    var password: String?,

    @Column
    var email: String?,

    @OneToMany(mappedBy = "user")
    val notes: List<NoteEntity> = ArrayList()
): BaseEntity() {
    constructor(): this(
        0L, "", null, null, null
    )

    companion object {
        fun toDomain(entity: UserEntity): User {
            return User(entity.id,
                entity.name,
                entity.email,
                entity.nickName,
                entity.createdBy,
                entity.createdDate,
                entity.updatedBy,
                entity.updatedDate
            )
        }
    }
}