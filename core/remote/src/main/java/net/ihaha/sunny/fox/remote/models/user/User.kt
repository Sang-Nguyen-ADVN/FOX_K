package net.ihaha.sunny.fox.remote.models.user

import androidx.annotation.NonNull
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true )
data class User(
    @NonNull
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String? = "",
    @Json(name = "url")
    val url: String? = "",
    @Json(name = "username")
    val username: String? = "",
    @Json(name = "avatar")
    val avatar: String? = "",
    @Json(name = "following")
    val following: Boolean? = false,
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