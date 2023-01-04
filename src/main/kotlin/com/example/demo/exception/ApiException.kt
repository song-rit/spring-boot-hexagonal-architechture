package com.example.demo.exception

import org.springframework.http.HttpStatus

open class ApiException : BaseException(){
    open val httpStatus: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR
    open val code: String = "api-001"
}