package com.example.demo.adapter.api.github

import com.example.demo.domain.port.user.GetUserFromGitHubPort
import com.example.demo.domain.port.user.model.GetUserFromGitHubPortResponse
import com.example.demo.exception.ApiException
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Repository
import java.util.logging.Logger

@Profile("!dev")
@Repository
class GitHubUserApiAdapter(
        private val gitHubUserAPI: GitHubUserAPI
) : GetUserFromGitHubPort {

    private val logger = Logger.getLogger(GitHubUserApiAdapter::class.java.name)

    override fun getUserFromGitHub(username: String): GetUserFromGitHubPortResponse {
        try {
            logger.info("calling api github user")
            val response = gitHubUserAPI.getUser(username)
            return GetUserFromGitHubPortResponse(
                    name = response.name,
                    id = response.id,
                    pic = response.avatarUrl,
                    url = response.htmlUrl)
        } catch (ex: ApiException) {
            throw ex
        }
    }
}