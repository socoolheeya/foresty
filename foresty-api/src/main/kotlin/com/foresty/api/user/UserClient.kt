package com.foresty.api.user

import com.foresty.domain.entities.user.User
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "foresty-api", url = "http://localhost:8123")
interface UserClient {

    @GetMapping("/users/email/{email}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun get(@PathVariable(name = "email", required = true) email: String)

    @GetMapping("/users", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAll()

    @PostMapping("/users", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun post(@RequestBody user: User)

    @PutMapping("/users/email/{email}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun put(@PathVariable(name = "email", required = true) email: String, @RequestBody user: User)

    @DeleteMapping("/users/email/{email}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun delete(@PathVariable(name = "email", required = true) email: String)

}