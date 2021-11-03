package com.example.userservice.service

import com.example.userservice.dto.request.UserRequest
import com.example.userservice.dto.response.UserView
import com.example.userservice.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
) {

    @Transactional
    fun createUser(userRequest: UserRequest): UserView {
        val user = userRepository.save(userRequest.toEntity())
        return UserView.of(user)
    }
}