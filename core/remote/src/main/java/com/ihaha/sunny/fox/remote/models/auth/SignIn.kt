package com.ihaha.sunny.fox.remote.models.auth

import com.ihaha.sunny.fox.remote.models.auth.response.SignInError

data class SignIn(
    val signInSuccessfully: Boolean,
    val signInError: SignInError?,
    val customMessage: String?
)