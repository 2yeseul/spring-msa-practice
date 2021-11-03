package com.example.userservice.dto.request

import com.example.userservice.domain.User
import java.time.LocalDate
import java.util.*

data class UserRequest(
    val email: String,
    val name: String,
    val password: String
) {
    fun toEntity(): User {
        return User(
            id = null,
            email = this.email,
            name = this.name,
            password = this.password,
            userId = UUID.randomUUID().toString(),
            createdAt = LocalDate.now()
        )
    }
}