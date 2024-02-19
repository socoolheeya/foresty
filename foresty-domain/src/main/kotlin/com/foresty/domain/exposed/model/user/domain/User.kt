package com.foresty.domain.exposed.model.user.domain

import com.foresty.domain.exposed.model.user.dao.UserDao
//import com.foresty.domain.jpa.model.user.UserEntity
import java.time.LocalDateTime


data class User(
    var id: Long,
    var name: String? = null,
    var email: String? = null,
    var nickName: String? = null,
    var createdBy: String? = null,
    var createdDate: LocalDateTime? = null,
    var updatedBy: String? = null,
    var updatedDate: LocalDateTime? = null
) {
    constructor(): this(
        id = 0L,
        name = null,
        email = null,
        nickName = null,
        createdBy = null,
        createdDate = null,
        updatedBy = null,
        updatedDate = null,
    )
    companion object {
        fun toDao(user: User): UserDao {
            return UserDao.new {
                name =  user.name.let { it.toString() }
                email = user.email.let { it.toString() }
            }
        }

//        fun toEntity(user: User): UserEntity {
//            return UserEntity(
//                id = user.id,
//                name = user.name.let { it.toString() },
//                password = null,
//                nickName = null,
//                email = user.email
//            )
//        }
    }


}

