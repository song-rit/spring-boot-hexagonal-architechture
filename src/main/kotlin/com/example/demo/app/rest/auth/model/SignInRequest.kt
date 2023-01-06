package com.example.demo.app.rest.auth.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class SignInRequest(val username: String, val password: String)