package  net.ihaha.sunny.fox.remote.models.auth

class LoggedUser(
    val email: String,
    var displayName: String?
) {
    init {
        if (displayName.isNullOrBlank()) {
            val indexOfAtSign = email.indexOf("@")
            displayName = email.substring(0, indexOfAtSign)
        }
    }
}