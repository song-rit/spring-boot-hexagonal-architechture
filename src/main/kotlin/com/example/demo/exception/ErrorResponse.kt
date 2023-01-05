package com.example.demo.exception

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ErrorResponse (
    val code: String,
    val message: String,
    val description: String,
    val error: Any?
)