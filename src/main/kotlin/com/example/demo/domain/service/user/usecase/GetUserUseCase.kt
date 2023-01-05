package com.example.demo.domain.service.user.usecase

import com.example.demo.domain.service.user.model.GetUserResult


interface GetUserUseCase {
    fun getUser(getUserCommand: GetUserCommand): GetUserResult
}

data class GetUserCommand(val username: String)