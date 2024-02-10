package com.foresty.api.user

import com.foresty.api.user.service.UserService
import com.foresty.domain.entities.user.domain.User
import org.springframework.stereotype.Component
import org.springframework.util.ObjectUtils
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono


@Component
class UserHandler(private val userService: UserService) {
    suspend fun getUserAll(req: ServerRequest): Mono<ServerResponse> {
        val users: List<User> = userService.getUserAll()

        return users.flatMap { user ->
            if(ObjectUtils.isEmpty(user)) {
                notFou
            }
        }
    }

}