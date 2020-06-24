package net.ihaha.sunny.fox.data.model.categories

import net.ihaha.sunny.fox.remote.models.comment.CommentatorsData
import net.ihaha.sunny.fox.remote.models.tags.TagsData
import net.ihaha.sunny.fox.remote.models.user.UserData
import org.jetbrains.annotations.NotNull

data class Newest(
    val id: String,
    val title: String? = "",
    val url: String? = "",
    val user_Id: String? = "",
    val contentsShort: String? = "",
    val publishedAt: String? = "",
    val isPublished: Boolean = true,
    val updatedAt: String? = "",
    val readingTime: String? = "0",
    val points: String? = "0",
    val viewsCount: String? = "0",
    val clipsCount: String? = "0",
    val commentsCount: String? = "0",
    val ratedValue: String? = "",
    val thumbnailUrl: String? = "",

    val user: UserData? = null,
    val tags: TagsData? = null,
    val commentators: CommentatorsData? = null
)
