package com.foresty.domain.jpa.model.note

import com.foresty.domain.exposed.model.note.domain.Content
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
@Table(name = "content")
class ContentEntity(
    @Id
    @Column(name = "contentId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column
    val nose: String,

    @Column
    val taste: String,

    @Column
    val finish: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "noteId", foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
    val note: NoteEntity,

    @OneToMany(mappedBy = "content")
    val categories: List<CategoryEntity>
) {
    companion object {
        fun toDomain(entity: ContentEntity): Content {
            return Content(
                nose = entity.nose,
                taste = entity.taste,
                finish = entity.finish
            )
        }
    }
}