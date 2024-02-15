package com.foresty.api.user.controller

import com.foresty.api.user.service.UserService
import com.foresty.domain.entities.user.domain.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(private val userService: UserService) {

    @GetMapping("/users")
    suspend fun findAll(): List<User>? {
        return userService.getUserAll()
    }

    @GetMapping("/users/{id}")
    suspend fun find(@PathVariable id: Long): User? {
        return userService.getUser(id)
    }

    @PostMapping("/users")
    suspend fun create(@RequestBody user: User): User {
        return userService.registerUser(user)
    }

    @PutMapping("/users/{id}")
    suspend fun modify(@PathVariable id: Long, @RequestBody user: User) {
        userService.modifyUser(user)
    }

    @GetMapping("/test")
    suspend fun test(): String {
        return "test"
    }
}