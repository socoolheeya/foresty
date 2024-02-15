package com.foresty.domain.entities.user.domain

import com.foresty.domain.entities.user.dao.UserDao

data class User(
    val id: Long,
    val name: String,
    val password: String,
    val email: String
) {
    companion object {
        fun toDao(user: User): UserDao {
            return UserDao.new {
                name =  user.name
                password = user.password
                email = user.email
            }
        }
    }
}

