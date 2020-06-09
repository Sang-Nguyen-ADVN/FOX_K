package net.ihaha.sunny.fox.remote.models.user

//import androidx.room.Embedded
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserData(
//    @Embedded(prefix = "data")
    @Json(name = "data")
    val user : User? = null
)