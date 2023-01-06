package com.example.demo.app.rest.auth

import com.example.demo.app.rest.auth.model.SignInRequest
import com.example.demo.app.rest.auth.model.SignInResponse
import com.example.demo.domain.service.auth.model.SignInResult
import com.example.demo.domain.service.auth.usecase.SignInUseCase
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import java.util.logging.Logger


@RestController
@RequestMapping("/api/v1/auth")
class AuthenController(private val signInUseCase: SignInUseCase) {

    private val logger = Logger.getLogger(AuthenController::class.java.name)

    @PostMapping("/signIn")
    fun signIN(
            @RequestBody request: SignInRequest,
    ): SignInResponse {
        logger.info("request: $request")
        val command = SignInUseCase.Command(
                username = request.username,
                password = request.password
        )
        val result = signInUseCase.signIn(command)
        return toSignInResponse(result)
    }

    fun toSignInResponse(result: SignInResult): SignInResponse {
        return SignInResponse(
                accessToken = result.accessToken,
                refreshToken = result.refreshToken,
        )
    }
}



