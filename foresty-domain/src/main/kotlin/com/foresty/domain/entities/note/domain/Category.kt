package com.foresty.domain.entities.note.domain

import com.foresty.domain.entities.note.dao.CategoryDao

data class Category(
    val name: String,
    val content: Content
) {
    companion object {
        fun toDao(category: Category): CategoryDao {
            return CategoryDao.new {
                name = category.name
                content = Content.toDao(category.content)
            }
        }
    }
}