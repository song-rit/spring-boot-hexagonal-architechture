package com.example.demo.exception

open class ApiException : BaseException(){
    open val code: String = "cm-001"
    override val message: String = "some thing wrong"
}