package com.foresty.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing


@EnableJpaAuditing
@SpringBootApplication
class ForestyApiApplication

fun main(args: Array<String>) {
    runApplication<ForestyApiApplication>(*args)
}
