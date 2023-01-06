package com.example.demo.adapter.api.ad

import com.example.demo.adapter.api.ad.exception.SignAdApiUserNotFoundException
import com.example.demo.domain.port.auth.SignInToADPort
import com.example.demo.domain.port.auth.model.SignInToAdPortResponse
import com.example.demo.exception.ApiException
import org.springframework.stereotype.Repository
import java.util.logging.Logger


@Repository
class AdApiAdapter(
        private val signInToAdAPI: SignInToAdAPI
) : SignInToADPort {

    private val logger = Logger.getLogger(AdApiAdapter::class.java.name)

    override fun signInToAD(command: SignInToADPort.Command): SignInToAdPortResponse {
        logger.info("calling ad sign-in: $command")
        val response = signInToAdAPI.signInToAd(
                username = command.username,
                password = command.password)

        logger.info("response ad sign-in: $response")

        try {
            if(response.result == "ok") {
                return SignInToAdPortResponse("pass")
            } else {
                throw SignAdApiUserNotFoundException()
            }
        } catch (ex: ApiException) {
            throw ex;
        }
    }
}