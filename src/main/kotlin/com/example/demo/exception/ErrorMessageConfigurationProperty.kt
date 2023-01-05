package com.example.demo.exception

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "error-message-config")
class ErrorMessageConfigurationProperty {
    lateinit var codes: Map<String, ErrorMessageConfig>

    class ErrorMessageConfig {
        var message: ErrorMessageDetail = ErrorMessageDetail()
        lateinit var description: String
    }

    class ErrorMessageDetail {
        lateinit var en: String
        lateinit var th: String
    }
}



