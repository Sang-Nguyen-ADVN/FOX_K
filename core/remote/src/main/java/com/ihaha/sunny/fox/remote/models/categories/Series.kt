package com.ihaha.sunny.fox.remote.models.categories

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.ihaha.sunny.fox.remote.models.comment.CommentatorsData
import com.ihaha.sunny.fox.remote.models.tags.TagsData
import com.ihaha.sunny.fox.remote.models.user.UserData
import org.jetbrains.annotations.NotNull

@JsonClass(generateAdapter = true)
data class Series(
    @NotNull
    @Json(name = "id")
    val id: String,
    @Json(name = "title")
    val title: String? = "",
    @Json(name = "url")
    val url: String? = "",
    @Json(name = "user_id")
    val user_Id: String? = "",
    @Json(name = "contents_short")
    val contentsShort: String? = "",
    @Json(name = "published_at")
    val publishedAt: String? = "",
    @Json(name = "is_published")
    val isPublished: Boolean = true,
    @Json(name = "updated_at")
    val updatedAt: String? = "",
    @Json(name = "reading_time")
    val readingTime: String? = "0",
    @Json(name = "points")
    val points: String? = "0",
    @Json(name = "views_count")
    val viewsCount: String? = "0",
    @Json(name = "clips_count")
    val clipsCount: String? = "0",
    @Json(name = "comments_count")
    val commentsCount: String? = "0",
    @Json(name = "rated_value")
    val ratedValue: String? = "",
    @Json(name = "thumbnail_url")
    val thumbnailUrl: String? = "",

//    @Embedded(prefix = "user")
    @Json(name = "user")
    val user: UserData? = null,
//    @Embedded(prefix = "tags")
    @Json(name = "tags")
    val tags: TagsData? = null,
//    @Embedded(prefix = "commentators")
    @Json(name = "commentators")
    val commentators: CommentatorsData? = null
)
