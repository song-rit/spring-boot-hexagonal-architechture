package com.example.demo.adapter.api.github

import com.example.demo.adapter.api.github.exception.GitHubApiException
import com.example.demo.adapter.api.github.model.GitHubAPIResponse
import com.example.demo.exception.ApiException
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestClientException
import org.springframework.web.client.RestTemplate
import java.util.logging.Logger

@Profile("!dev")
@Repository
class GitHubUserAPI {

    private val logger = Logger.getLogger(GitHubUserAPI::class.java.name)
    fun getUser(username: String): GitHubAPIResponse {
        val url = "https://api.github.com/users/$username"

        try {
            val response = RestTemplate().getForEntity(url, String::class.java)
            val json = response.body

            logger.info("api github user response: $json")

            val mapper = jacksonObjectMapper()
            return mapper.readValue(json, GitHubAPIResponse::class.java)
            // Parse the JSON response and map it to a User object
        } catch (ex: RestClientException) {
            // Handle the exception
            throw GitHubApiException()
        } catch (ex: ApiException) {
            throw GitHubApiException()
        }
    }
}