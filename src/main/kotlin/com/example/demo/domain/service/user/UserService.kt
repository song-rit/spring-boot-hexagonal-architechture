package com.example.demo.domain.service.user

import com.example.demo.adapter.GitHubUserApiAdapter
import com.example.demo.domain.port.user.GetUserFromGitHubPort
import com.example.demo.domain.service.user.exception.UserErrorCommonException
import com.example.demo.domain.service.user.model.GetUserResult
import com.example.demo.domain.service.user.usecase.GetUserCommand
import com.example.demo.domain.service.user.usecase.GetUserUseCase
import com.example.demo.exception.ApiException
import org.springframework.stereotype.Service

@Service
class UserService(
        private val getUserFromGitHubPort: GetUserFromGitHubPort,
) : GetUserUseCase {

    override fun getUser(getUserCommand: GetUserCommand): GetUserResult {

        try {
            val userFromGitHub = getUserFromGitHubPort.getUserFromGitHub(getUserCommand.username)
            return GetUserResult(
                    id = userFromGitHub.id,
                    name = userFromGitHub.name,
                    pic = userFromGitHub.pic,
                    url = userFromGitHub.url
            )
        } catch (ex: ApiException) {
            throw UserErrorCommonException()
        }
    }
}



