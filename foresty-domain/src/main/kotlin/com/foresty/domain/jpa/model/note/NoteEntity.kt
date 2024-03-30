package com.foresty.domain.jpa.model.note

import com.foresty.domain.common.entity.BaseEntity
import com.foresty.domain.enums.NoteEnum
import com.foresty.domain.jpa.model.user.UserEntity
import jakarta.persistence.Column
import jakarta.persistence.ConstraintMode
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "note")
class NoteEntity(
    @Id
    @Column(name = "noteId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column
    var title: String,

    @Column
    var star: NoteEnum.Star,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", foreignKey = ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    var user: UserEntity,

    @OneToMany(mappedBy = "note")
    val contents: List<ContentEntity>
): BaseEntity() {

}
