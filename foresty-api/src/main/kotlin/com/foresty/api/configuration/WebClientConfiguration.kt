package com.foresty.api.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfiguration {

    @Value("base.url")
    lateinit var url: String

    @Bean
    fun webClient(builder: WebClient.Builder): WebClient =
        builder
            .baseUrl(url)
            .defaultHeaders { headers -> headers["Content-type"] = "application/json" }
            .build()
}