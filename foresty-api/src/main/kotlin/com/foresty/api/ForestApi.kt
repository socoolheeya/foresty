package com.foresty.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ForestApi {


    @GetMapping("/hello")
    fun helloWorld() {
        println("hello")
        //userClient.getAll()
    }
}