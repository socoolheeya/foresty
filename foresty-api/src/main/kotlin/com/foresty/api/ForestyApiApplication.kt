package com.foresty.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
    scanBasePackages = ["com.foresty.api", "com.foresty.domain"]
)
class ForestyApiApplication

fun main(args: Array<String>) {
    runApplication<ForestyApiApplication>(*args)
}
