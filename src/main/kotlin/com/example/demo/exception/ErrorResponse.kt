package com.example.demo.exception

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class ErrorResponse (
    val code: String,
    val message: String,
    val description: String,
    val error: Any
)