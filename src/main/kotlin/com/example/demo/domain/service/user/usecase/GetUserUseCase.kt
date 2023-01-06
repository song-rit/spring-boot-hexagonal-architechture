package com.example.demo.domain.service.user.usecase

import com.example.demo.domain.service.user.model.GetUserResult


interface GetUserUseCase {
    fun getUser(getUserCommand: Command): GetUserResult

    data class Command(val username: String)
}

