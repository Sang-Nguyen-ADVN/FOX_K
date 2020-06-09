package net.ihaha.sunny.fox.remote.models.auth

import net.ihaha.sunny.fox.remote.models.auth.response.SignInError

data class SignIn(
    val signInSuccessfully: Boolean,
    val signInError: SignInError?,
    val customMessage: String?
)