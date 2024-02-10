package com.foresty.api.user.service

import com.foresty.domain.entities.user.domain.User
import org.springframework.stereotype.Service

@Service
class UserService {
    suspend fun getUserAll(): List<User> {
        return User.all().toList();
    }

    suspend fun getUser(id: Long): User? {
        return User.findById(id)
    }

    suspend fun registerUser(user: User) {
        User.new {
          name = user.name
          password = user.password
          email = user.password
        }
    }

    suspend fun modifyUser(user: User) {
        getUser(user.id.value)?.apply {
            name = user.name
            email = user.email
        }
    }

    suspend fun deleteUser(id: Long) {
        getUser(id)?.delete()
    }
}