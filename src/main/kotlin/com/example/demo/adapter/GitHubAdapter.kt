package com.example.demo.adapter

import com.example.demo.adapter.api.github.GitHubUserAPI
import com.example.demo.domain.port.user.GetUserFromGitHubPort
import com.example.demo.domain.port.user.model.GetUserFromGitHubPortResponse
import com.example.demo.exception.ApiException
import org.springframework.stereotype.Repository


@Repository
class GitHubAdapter(
        private val gitHubUserAPI: GitHubUserAPI
) : GetUserFromGitHubPort {

    override fun getUserFromGitHub(username: String): GetUserFromGitHubPortResponse {
        try {
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