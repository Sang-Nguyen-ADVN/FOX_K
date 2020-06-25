package com.ihaha.sunny.fox.remote.models.categories


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Organizations(
    @Json(name = "id")
    val id: String,
    @Json(name = "name")
    val name: String? = "",
    @Json(name = "user_id")
    val userId: Int = 0,
    @Json(name = "avatar")
    val avatar: String? = "",
    @Json(name = "slug")
    val slug: String? = "",
    @Json(name = "following")
    val following: Boolean,
    @Json(name = "followers_count")
    val followersCount: Int = 0,
    @Json(name = "location")
    val location: String? = "",
    @Json(name = "posts_count")
    val postsCount: Int = 0,
    @Json(name = "members_count")
    val membersCount: Int = 0,
    @Json(name = "google_analytics_id")
    val googleAnalyticsId: String? = "",
    @Json(name = "short_description")
    val shortDescription: String? = "",
    @Json(name = "full_description")
    val fullDescription: String? = "",
    @Json(name = "approved")
    val approved: Boolean,
    @Json(name = "website")
    val website: String? = ""
)