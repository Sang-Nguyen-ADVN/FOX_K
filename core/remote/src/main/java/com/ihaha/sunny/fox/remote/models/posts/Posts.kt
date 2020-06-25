package com.ihaha.sunny.fox.remote.models.posts

import androidx.annotation.NonNull
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.ihaha.sunny.fox.remote.models.tags.Tags
import com.ihaha.sunny.fox.remote.models.user.User

@JsonClass(generateAdapter = true)
data class Posts(
    @NonNull
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val title: String? = "",
    @Json(name = "canonical_url")
    val canonicalUrl: String? = "",
    @Json(name = "path")
    val path: String? = "",
    @Json(name = "user")
    val user: User? = null,
    @Json(name = "tags")
    val tags: ArrayList<Tags>? = null
)