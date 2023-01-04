package com.example.demo.app.rest.user

import com.example.demo.app.rest.user.model.UserResponse
import com.example.demo.domain.service.user.GetUserCommand
import com.example.demo.domain.service.user.GetUserUseCase
import com.example.demo.domain.service.user.UserService
import com.example.demo.domain.service.user.model.GetUserResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(private val getUserUseCase: GetUserUseCase) {

    @GetMapping("/{username}")
    fun getUser(@PathVariable username: String): UserResponse {
        val command = GetUserCommand(username = username)
        val result = getUserUseCase.getUser(command)
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



