package com.foresty.api.user.router

import kotlinx.coroutines.coroutineScope
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import reactor.kotlin.core.publisher.toMono


//@Configuration
//class UserRouter(private val handler: UserHandler) {
//
//    suspend fun userRouter() = router {
//        GET("/user") {
//            handler.getUserAll().flatMap { response ->
//                ServerResponse.status(response.statusCode())
//                    .headers { headers -> headers.putAll(response.headers()) }
//                    .bodyValue(response.toMono())
//            }
//        }
//    }
//}