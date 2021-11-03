package com.example.userservice.dto

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
data class Greeting(
        @Value("\${greeting.message}")
        val message: String
) {
}