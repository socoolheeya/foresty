package com.foresty.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.web.servlet.config.annotation.EnableWebMvc


@EnableJpaAuditing
@SpringBootApplication(
    scanBasePackages = ["com.foresty.api", "com.foresty.domain"]
)
class ForestyApiApplication

fun main(args: Array<String>) {
    runApplication<ForestyApiApplication>(*args)
}
