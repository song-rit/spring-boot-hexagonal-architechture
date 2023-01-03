package com.example.demo.domain.service.user.exception

import com.example.demo.exception.BusinessException

class UserErrorCommonException : BusinessException() {
    override val code = "user-001"
    override val message = "some thing wrong"

}