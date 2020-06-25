package com.ihaha.sunny.fox.remote.models.posts


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.ihaha.sunny.fox.remote.models.user.UserPost

@JsonClass(generateAdapter = true)
data class PostsItem(
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val title: String? = "",
    @Json(name = "canonical_url")
    val canonicalUrl: String? = "",
    @Json(name = "path")
    val path: String? = "",
    @Json(name = "user")
    val user: UserPost? = null
)