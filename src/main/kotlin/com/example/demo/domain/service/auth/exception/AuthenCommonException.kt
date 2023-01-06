package com.example.demo.domain.service.auth.exception

import com.example.demo.exception.BusinessException
import org.springframework.http.HttpStatus

class AuthenCommonException : BusinessException() {
    override val httpStatus: HttpStatus = HttpStatus.UNPROCESSABLE_ENTITY
    override val code: String = "auth-001"
}