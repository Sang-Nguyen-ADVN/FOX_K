package net.ihaha.sunny.fox.remote.models.comment

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import org.jetbrains.annotations.NotNull

@JsonClass(generateAdapter = true)
data class Commentators(
    @NotNull
    @Json(name = "id")
    val id: Int,
    @Json(name = "avatar")
    val avatar: String?= "",
    @Json(name = "banned_at")
    val bannedAt: String = "",
    @Json(name = "followers_count")
    val followersCount: Int? = 0,
    @Json(name = "name")
    val name: String = "",
    @Json(name = "posts_count")
    val postsCount: Int? = 0,
    @Json(name = "reputation")
    val reputation: Int? = 0,
    @Json(name = "url")
    val url: String = "",
    @Json(name = "username")
    val username: String = ""
)