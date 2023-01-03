package com.example.demo.domain.service.user

import com.example.demo.domain.service.user.model.GetUserResult


interface GetUserUseCase {
    fun getUser(getUserCommand: GetUserCommand): GetUserResult
}

data class GetUserCommand(val username: String)