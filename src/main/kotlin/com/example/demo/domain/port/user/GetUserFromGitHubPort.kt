package com.example.demo.domain.port.user

import com.example.demo.domain.port.user.model.GetUserFromGitHubPortResponse

interface GetUserFromGitHubPort {
    fun getUserFromGitHub(username: String): GetUserFromGitHubPortResponse
}