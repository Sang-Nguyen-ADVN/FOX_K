package net.ihaha.sunny.fox.remote.models.search


import com.squareup.moshi.Json
import net.ihaha.sunny.fox.remote.models.tags.Tags
import net.ihaha.sunny.fox.remote.models.user.User
import org.jetbrains.annotations.NotNull

data class Search(
    @NotNull
    @Json(name = "id")
    val id: String,
    @Json(name = "points")
    val points: String = "0",
    @Json(name = "published_at")
    val publishedAt: String = "",
    @Json(name = "rated_value")
    val ratedValue: String = "",
    @Json(name = "slug")
    val slug: String = "",
    @Json(name = "system")
    val system: String = "",
    @Json(name = "teaser")
    val teaser: String = "",
    @Json(name = "title")
    val title: String = "",
    @Json(name = "transliterated")
    val transliterated: String = "",
    @Json(name = "type")
    val type: String = "",
//    @Embedded(prefix = "user")
    @Json(name = "user")
    val user: User? = null,
//    @Embedded(prefix = "tags")
    @Json(name = "tags")
    val tags: ArrayList<Tags>? = null
)