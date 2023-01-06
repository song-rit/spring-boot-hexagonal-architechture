package com.example.demo.domain.service.auth.model

data class SignInResult(val accessToken: String, val refreshToken: String, val refreshTokenExpiredIn: Int, val accessTokenExpiredIn: Int)
