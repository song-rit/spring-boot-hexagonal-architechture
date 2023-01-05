package com.example.demo.exception

import com.example.demo.app.constant.LanguageConstant
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletResponse
import java.util.logging.Logger

@RestControllerAdvice
class RestExceptionHandler(
        private val errorMessageConfig: ErrorMessageConfigurationProperty,
        private val environment: EnvironmentConfigurationProperty
) {

    private val logger = Logger.getLogger(this.toString())

    companion object {
        val ENV_EXCLUDE_STACK_TRACE = arrayOf("uat")
        const val defaultErrorCode = "cm-001"
        const val defaultErrorMessage = "Sorry! something wrong. Please try again."
    }

    @ExceptionHandler(value = [BusinessException::class])
    @ResponseBody
    fun handleBusinessException(
            ex: BusinessException,
            response: HttpServletResponse
    ): ResponseEntity<ErrorResponse> {
        val locale = LocaleContextHolder.getLocale()

        val body = ErrorResponse(
                code = ex.code,
                message = ErrorMessageFactory(errorMessageConfig).getMessage(ex.code, LanguageConstant.toLocale(locale)),
                description = ErrorMessageFactory(errorMessageConfig).getDescription(ex.code),
                error = displayCauseMessage(ex)
        )
        return ResponseEntity(body, ex.httpStatus)
    }

    private val displayCauseMessage: (Exception) -> String? = { ex ->
        if (ENV_EXCLUDE_STACK_TRACE.any { it == environment.currentEnvironment })
            null
        else
            ex.stackTraceToString()
    }
}