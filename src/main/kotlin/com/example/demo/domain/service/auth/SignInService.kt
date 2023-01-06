package com.example.demo.domain.service.auth

import com.example.demo.domain.port.auth.SignInToADPort
import com.example.demo.domain.service.auth.exception.AuthenCommonException
import com.example.demo.domain.service.auth.exception.AuthenSignInInvalidateCredentialException
import com.example.demo.domain.service.auth.model.SignInResult
import com.example.demo.domain.service.auth.usecase.SignInUseCase
import com.example.demo.exception.ApiException
import com.example.demo.exception.BusinessException
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class SignInService(
        private val signInToADPort: SignInToADPort,
) : SignInUseCase {

    val logger = Logger.getLogger(SignInService::class.java.name)

    override fun signIn(command: SignInUseCase.Command): SignInResult {

        logger.info("validating")
        val isNotValidUsernamePattern = isNotValidUsernamePattern(username = command.username)

        logger.info("isNotValidUsernamePattern: $isNotValidUsernamePattern")
        if(isNotValidUsernamePattern) {
            throw AuthenSignInInvalidateCredentialException()
        }

        // validate user source
        //  TODO( if user == 'os': check username and password at database)

        try {
            val signInResponse = signInToADPort.signInToAD(SignInToADPort.Command(
                    username = command.username,
                    password = command.password
            ))
            if (signInResponse.status == "success") {
                return SignInResult(
                        accessToken = "access_token",
                        refreshToken = "refresh_token",
                        accessTokenExpiredIn = 3000,
                        refreshTokenExpiredIn = 3000,
                )
            } else {
                throw AuthenSignInInvalidateCredentialException()
            }

        } catch (ex: BusinessException) {
            throw AuthenCommonException()
        } catch (ex: ApiException) {
            if(ex.code == "api-ad-001") {
                throw AuthenSignInInvalidateCredentialException()
            }
            throw AuthenCommonException()
        }
    }

    fun isNotValidUsernamePattern(username: String): Boolean {
        if(username.contains("test")) {
            return true
        }
        return false
    }
}



