package com.example.demo.adapter.api.github.exception

import com.example.demo.exception.ApiException

class GitHubApiException : ApiException() {
    override val code = "gh-001"
    override val message = "some thing wrong"

}