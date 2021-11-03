package com.example.userservice.controller

import com.example.userservice.dto.Greeting
import com.example.userservice.dto.request.UserRequest
import com.example.userservice.dto.response.UserView
import com.example.userservice.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
        private val greeting: Greeting,
        private val userService: UserService
) {

    @GetMapping("/health-check")
    fun status(): String {
        return "It's Working in User Service"
    }

    @GetMapping("/welcome")
    fun welcome(): String? {
        return greeting.message
    }

    @PostMapping("/users")
    fun createUser(@RequestBody userRequest: UserRequest): ResponseEntity<Any> {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userRequest))
    }
}