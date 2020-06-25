package  com.ihaha.sunny.fox.remote.models.auth

import com.ihaha.sunny.fox.remote.models.auth.response.RegistrationError

class SignUp (
    val signUpSuccessfully: Boolean,
    val signUpError: RegistrationError?,
    val signUpMessage: String?
) {
}