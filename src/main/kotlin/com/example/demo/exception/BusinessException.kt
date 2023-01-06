package com.example.demo.exception

import org.springframework.http.HttpStatus

open class BusinessException : BaseException(){
    open val httpStatus: HttpStatus = HttpStatus.UNPROCESSABLE_ENTITY
    open val code: String = "comm-001"
}