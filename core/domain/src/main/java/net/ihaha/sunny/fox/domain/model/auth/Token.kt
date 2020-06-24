package net.ihaha.sunny.fox.domain.model.auth

data class Token(
    var account_pk: Int? = -1,
    var token: String? = null
)
