package com.example.firstservice.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/first-service")
class FirstServiceController {

    private val log: Logger = LoggerFactory.getLogger(FirstServiceController::class.java)

    @GetMapping("/welcome")
    fun welcome(): String {
        return "Welcome to First Service"
    }

    @GetMapping("/message")
    fun message(@RequestHeader("first-request") header: String): String {
        log.info("header is $header")
        return "Hello World in First Service"
    }
}