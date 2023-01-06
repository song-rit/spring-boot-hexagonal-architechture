package com.example.demo.app.rest.user

import com.example.demo.app.rest.user.model.UserResponse
import com.example.demo.domain.service.user.usecase.GetUserUseCase
import com.example.demo.domain.service.user.model.GetUserResult
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.slf4j.LoggerFactory


@RestController
@RequestMapping("/api/v1/users")
class UserController(private val getUserUseCase: GetUserUseCase) {

    private val logger = LoggerFactory.getLogger(this.toString())

    @GetMapping("/{username}")
    fun getUser(
            @PathVariable username: String,
    ): UserResponse {
        val command = GetUserUseCase.Command(username = username)
        val result = getUserUseCase.getUser(command)
        logger.info("username: $username")
        return toGetUserResponse(result)
    }

    fun toGetUserResponse(result: GetUserResult): UserResponse {
        return UserResponse(
                id = result.id,
                name = result.name,
                pic = result.pic,
                url = result.url
        )
    }
}



