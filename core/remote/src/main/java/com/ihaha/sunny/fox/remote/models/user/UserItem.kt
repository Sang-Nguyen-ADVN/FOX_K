package com.ihaha.sunny.fox.remote.models.user


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true )
data class UserItem(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String? = "",
    @Json(name = "username")
    val username: String? = "",
    @Json(name = "avatar")
    val avatar: String? = "",
    @Json(name = "following")
    val following: Boolean,
    @Json(name = "reputation")
    val reputation: String? = "",
    @Json(name = "followers_count")
    val followersCount: String? = "",
    @Json(name = "posts_count")
    val postsCount: String? = "",
    @Json(name = "answers_count")
    val answersCount: String? = "",
    @Json(name = "questions_count")
    val questionsCount:  String? = "",
    @Json(name = "banned_at")
    val bannedAt: String? = ""
)