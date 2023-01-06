package com.example.demo.domain.service.auth.usecase

import com.example.demo.domain.service.auth.model.SignInResult


interface SignInUseCase {
    fun signIn(signInCommand: Command): SignInResult

    data class Command(val username: String, val password: String)
}

