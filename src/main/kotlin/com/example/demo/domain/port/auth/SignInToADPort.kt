package com.example.demo.domain.port.auth

import com.example.demo.domain.port.auth.model.SignInToAdPortResponse

interface SignInToADPort {
    fun signInToAD(command: Command): SignInToAdPortResponse

    data class Command(val username: String, val password: String)
}
