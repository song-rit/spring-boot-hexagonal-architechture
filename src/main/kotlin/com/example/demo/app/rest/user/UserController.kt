package com.example.demo.app.rest.user

import com.example.demo.app.rest.user.model.UserResponse
import com.example.demo.domain.service.user.usecase.GetUserCommand
import com.example.demo.domain.service.user.usecase.GetUserUseCase
import com.example.demo.domain.service.user.model.GetUserResult
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.web.bind.annotation.*
import java.util.logging.Logger


@RestController
@RequestMapping("/users")
class UserController(private val getUserUseCase: GetUserUseCase) {

    private val logger = Logger.getLogger(this.toString())

    @GetMapping("/{username}")
    fun getUser(
            @PathVariable username: String,
    ): UserResponse {
        val locale = LocaleContextHolder.getLocale()
        val command = GetUserCommand(username = username)
        val result = getUserUseCase.getUser(command)
        logger.info("locale: $locale")
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



