package com.example.demo.adapter.api.ad

import com.example.demo.adapter.api.ad.model.SignInToAdAPIResponse
import com.example.demo.adapter.api.github.exception.GitHubApiException
import com.example.demo.adapter.api.github.model.GitHubAPIResponse
import com.example.demo.exception.ApiException
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestClientException
import org.springframework.web.client.RestTemplate

@Repository
class SignInToAdAPI
{
    fun signInToAd(username: String, password: String): SignInToAdAPIResponse {
        return SignInToAdAPIResponse(
                result = "pl"
        )
    }
}