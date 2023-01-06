package com.example.demo.adapter.api.ad.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class SignInToAdAPIResponse(
        val result: String
)