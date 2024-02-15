package com.foresty.api.user.handler

import com.foresty.api.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono


@Component
class UserHandler(private val userService: UserService) {
    suspend fun getUserAll(): Mono<ServerResponse> {
        return try {
            val users = userService.getUserAll() as Any
            ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(users))
        } catch (e: Exception) {
            ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("Error")
        }
    }
}