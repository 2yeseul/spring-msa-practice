package com.example.userservice.dto.response

import com.example.userservice.domain.User
import java.time.LocalDate

data class UserView(
    val id: Long?,
    val userId: String,
    val email: String,
    val password: String,
    val createdAt: LocalDate,
) {
    companion object {
        fun of(user: User): UserView {
            return UserView(
                id = user.id,
                userId = user.userId,
                email = user.email,
                password = user.password,
                createdAt = user.createdAt
            )
        }
    }
}