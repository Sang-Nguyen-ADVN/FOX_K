package com.ihaha.sunny.fox.remote.models.auth.response

enum class RegistrationError (val value: String) {
    USER_ALREADY_EXISTS("User already exists"),
    FAILED("User registration failed"),
    CANCELLED("User registration cancelled"),
    NOT_INITIALIZED("")
}