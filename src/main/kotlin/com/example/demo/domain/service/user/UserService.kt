package com.example.demo.domain.service.user

import com.example.demo.adapter.GitHubAdapter
import com.example.demo.domain.service.user.exception.UserErrorCommonException
import com.example.demo.domain.service.user.model.GetUserResult
import com.example.demo.exception.ApiException
import org.springframework.stereotype.Service

@Service
class UserService(
        private val githubAdapter: GitHubAdapter,
) : GetUserUseCase {

    override fun getUser(getUserCommand: GetUserCommand): GetUserResult {

        try {
            val userFromGitHub = githubAdapter.getUserFromGitHub(getUserCommand.username)
            return GetUserResult(
                    id = userFromGitHub.id,
                    name = userFromGitHub.name,
                    pic = userFromGitHub.pic,
                    url = userFromGitHub.url
            )
        } catch (e: ApiException) {
            throw UserErrorCommonException()
        }
    }
}



