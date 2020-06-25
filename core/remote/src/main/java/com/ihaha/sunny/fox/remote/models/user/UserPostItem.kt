package com.ihaha.sunny.fox.remote.models.user


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserPostItem(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String? = "",
    @Json(name = "username")
    val username: String? = "",
    @Json(name = "avatar")
    val avatar: String? = "",
    @Json(name = "following")
    val following: Boolean? = true,
    @Json(name = "reputation")
    val reputation: String? = "0",
    @Json(name = "followers_count")
    val followersCount: String? = "0",
    @Json(name = "posts_count")
    val postsCount: String? = "0",
    @Json(name = "answers_count")
    val answersCount: String? = "0",
    @Json(name = "questions_count")
    val questionsCount: String? = "0",
    @Json(name = "banned_at")
    val bannedAt: String? = ""
)