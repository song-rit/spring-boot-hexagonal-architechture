package com.example.demo.domain.service.auth.exception

import com.example.demo.exception.BusinessException
import org.springframework.http.HttpStatus

class AuthenSignInInvalidateCredentialException : BusinessException() {
    override val httpStatus: HttpStatus = HttpStatus.UNAUTHORIZED
    override val code: String = "auth-010"
}