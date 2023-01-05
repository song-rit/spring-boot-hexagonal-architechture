package com.example.demo.exception

class ErrorMessageFactory(
        private val errorMessageConfig: ErrorMessageConfigurationProperty
) {

    fun getMessage(errorCode: String, locale: String): String {
        return when(locale) {
            "en" -> errorMessageConfig.codes[errorCode]!!.message.en
            "th" -> errorMessageConfig.codes[errorCode]!!.message.th
            else -> errorMessageConfig.codes[errorCode]!!.message.en
        }
    }

    fun getDescription(errorCode: String): String {
        return errorMessageConfig.codes[errorCode]!!.description
    }
}