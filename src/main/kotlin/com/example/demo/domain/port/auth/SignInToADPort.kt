package com.example.demo.domain.port.auth

import com.example.demo.domain.port.auth.model.SignInTodPortResponse

interface SignInToADPort {
    fun signInToAD(command: Command): SignInTodPortResponse

    data class Command(val username: String, val password: String)
}
