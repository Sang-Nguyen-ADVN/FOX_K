package net.ihaha.sunny.fox.domain.model.auth

import net.ihaha.sunny.base.domain.BaseModel

data class User(
    var uid: String? = "",
    var email: String? = "",
    var username: String? = "",
    var phone: String? = "",
    var pictureUrl: String? = "",
    var token: String? = ""
) : BaseModel()
