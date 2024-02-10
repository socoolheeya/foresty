package com.foresty.api.user

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.function.ServerResponse
import org.springframework.web.servlet.function.router

@Configuration
class UserRouter(private val handler: UserHandler) {

    fun userRouter() = router {
        GET("/user") {
            ServerResponse.ok().body(from(handler.))
        }
    }
}