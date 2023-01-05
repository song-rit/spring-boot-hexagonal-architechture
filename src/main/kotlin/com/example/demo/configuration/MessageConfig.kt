package com.example.demo.configuration

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor
import org.springframework.web.servlet.i18n.SessionLocaleResolver
import java.util.*


@Configuration
class MessageConfig: WebMvcConfigurer {

//    @Bean
//    fun localeChangeInterceptor(): LocaleChangeInterceptor {
//        val localeChangeInterceptor = LocaleChangeInterceptor()
//        localeChangeInterceptor.paramName = HttpHeaders.ACCEPT_LANGUAGE
//        return localeChangeInterceptor
//    }
//
//    override fun addInterceptors(registry: InterceptorRegistry) {
//        registry.addInterceptor(localeChangeInterceptor())
//    }
//
//    @Bean
//    fun localeResolve() = SessionLocaleResolver().apply {
//        setDefaultLocale(Locale.GERMAN)
//    }
}