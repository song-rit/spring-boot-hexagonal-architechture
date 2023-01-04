package com.example.demo.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletResponse

@RestControllerAdvice
class RestExceptionHandler {

    companion object {
        const val defaultErrorMessage = "Sorry! something wrong. Please try again."
    }

    @ExceptionHandler(value = [BusinessException::class])
    @ResponseBody
    fun handleBusinessException(
            ex: BusinessException,
            response: HttpServletResponse
    ): ResponseEntity<ErrorResponse> {
        val body = ErrorResponse(
                code = ex.code,
                message = defaultErrorMessage,
                description = defaultErrorMessage,
                error = ex.toString()
        )
        return ResponseEntity(body, ex.httpStatus)
    }
}