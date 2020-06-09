package  net.ihaha.sunny.fox.remote.models.auth

import net.ihaha.sunny.fox.remote.models.auth.response.RegistrationError

class SignUp (
    val signUpSuccessfully: Boolean,
    val signUpError: RegistrationError?,
    val signUpMessage: String?
) {
}