package com.foresty.domain.exposed.model.note.domain

import com.foresty.domain.exposed.model.note.dao.CategoryDao

data class Category(
    val id: Long,
    val name: String
) {
    companion object {
        fun toDao(category: Category): CategoryDao {
            return CategoryDao.new {
                name = category.name
            }
        }
    }
}