package com.foresty.domain.entities.note.domain

import com.foresty.domain.entities.note.dao.ContentDao

data class Content(
    val nose: String,
    val taste: String,
    val finish: String,
    val note: Note
) {
    companion object {
        fun toDao(content: Content): ContentDao {
            return ContentDao.new {
                nose = content.nose
                taste = content.taste
                finish = content.finish
                note = Note.toDao(content.note)
            }
        }
    }
}
