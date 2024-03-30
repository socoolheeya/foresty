//package com.foresty.domain.exposed.model.note.domain
//
//import com.foresty.domain.exposed.model.note.dao.ContentDao
//
//data class Content(
//    val nose: String,
//    val taste: String,
//    val finish: String
//) {
//    companion object {
//        fun toDao(content: Content): ContentDao {
//            return ContentDao.new {
//                nose = content.nose
//                taste = content.taste
//                finish = content.finish
//            }
//        }
//    }
//}
