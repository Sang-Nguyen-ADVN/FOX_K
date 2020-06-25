package com.ihaha.sunny.fox.domain.model.auth

import com.ihaha.sunny.base.domain.BaseModel

data class User(
    var uid: String? = "",
    var email: String? = "",
    var username: String? = "",
    var phone: String? = "",
    var pictureUrl: String? = "",
    var token: String? = ""
) : BaseModel()
