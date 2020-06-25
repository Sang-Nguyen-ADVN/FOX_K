package com.ihaha.sunny.fox.remote.models.user


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserPost(
    @Json(name = "result")
    val userPostItem: UserPostItem
)