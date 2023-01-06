package com.example.demo.adapter.api.ad.exception

import com.example.demo.exception.ApiException

class SignAdApiUserNotFoundException : ApiException() {
    override val code = "api-ad-001"
    override val message = "some thing wrong"
}