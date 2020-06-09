package net.ihaha.sunny.fox.remote.models.tags


//import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import org.jetbrains.annotations.NotNull

@JsonClass(generateAdapter = true)
data class Tags(
//    @PrimaryKey
    @NotNull
    @Json(name = "id")
    val id: String,
    @Json(name = "slug")
    val slug: String? = "",
    @Json(name = "url")
    val url: String = "",
    @Json(name = "primary")
    val primary: Boolean,
    @Json(name = "name")
    val name: String? = "",
    @Json(name = "posts_count")
    val postsCount: String? = "",
    @Json(name = "questions_count")
    val questionsCount: String? = "",
    @Json(name = "followers_count")
    val followersCount: String? = "",
    @Json(name = "image")
    val image: String? = ""
)