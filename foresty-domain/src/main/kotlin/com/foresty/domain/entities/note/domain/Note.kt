package com.foresty.domain.entities.note.domain

import com.foresty.domain.entities.note.dao.NoteDao
import com.foresty.domain.entities.user.domain.User
import com.foresty.domain.enums.NoteEnum

data class Note(
    val title: String,
    val star: NoteEnum.Star,
    val user: User
) {
    companion object {
        fun toDao(note: Note): NoteDao {
            return NoteDao.new {
                title = note.title
                star = note.star
                user = User.toDao(note.user)
            }
        }
    }


}
