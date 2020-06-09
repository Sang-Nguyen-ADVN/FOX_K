package net.ihaha.sunny.fox.remote.models.tags
//import androidx.room.Embedded
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TagsData(
//    @Embedded(prefix = "data")
    @Json(name = "data")
    val result : Tags? = null
)