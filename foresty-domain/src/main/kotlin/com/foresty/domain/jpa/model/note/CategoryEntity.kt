package com.foresty.domain.jpa.model.note

import com.foresty.domain.exposed.model.note.domain.Category
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
import jakarta.persistence.Table

@Entity
@Table(name = "category")
class CategoryEntity(
    @Id
    @Column(name = "categoryId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column
    val name: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contentId", foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
    val content: ContentEntity
) {
    companion object {
        fun toDomain(entity: CategoryEntity): Category {
            return Category(
                entity.id,
                entity.name
            )
        }
    }
}
