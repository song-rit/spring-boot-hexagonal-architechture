package com.example.demo.domain.service.user.exception

import com.example.demo.exception.BusinessException
import org.springframework.http.HttpStatus

class UserErrorCommonException : BusinessException() {
    override val httpStatus: HttpStatus = HttpStatus.UNPROCESSABLE_ENTITY
    override val code: String = "user-001"
}