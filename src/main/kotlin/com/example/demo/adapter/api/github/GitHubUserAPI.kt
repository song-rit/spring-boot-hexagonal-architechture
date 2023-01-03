package com.example.demo.adapter.api.github

import com.example.demo.adapter.api.github.exception.GitHubApiException
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestClientException
import org.springframework.web.client.RestTemplate

@Repository
class GitHubUserAPI {
    fun getUser(username: String): GitHubAPIResponse {
        val url = "https://api.github.com/users/$username"

        try {
            val response = RestTemplate().getForEntity(url, String::class.java)
            val json = response.body
            val mapper = jacksonObjectMapper()
            return mapper.readValue(json, GitHubAPIResponse::class.java)
            // Parse the JSON response and map it to a User object
        } catch (e: RestClientException) {
            // Handle the exception
            throw GitHubApiException()
        }
    }
}