//package com.foresty.domain.exposed.model.note.domain
//
//import com.foresty.domain.exposed.model.note.dao.NoteDao
//import com.foresty.domain.exposed.model.user.domain.User
//import com.foresty.domain.enums.NoteEnum
//
//data class Note(
//    var id: Long,
//    var title: String,
//    var star: NoteEnum.Star
//) {
//    companion object {
//        fun toDao(note: Note): NoteDao {
//            return NoteDao.new {
//                title = note.title
//                star = note.star
//            }
//        }
//    }
//
//
//}
