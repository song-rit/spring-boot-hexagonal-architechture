package com.example.demo.exception

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class EnvironmentConfigurationProperty {

    @Value("\${spring.profiles.active:dev}")
    lateinit var  currentEnvironment: String
}