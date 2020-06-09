package net.ihaha.sunny.fox.remote.models.paging


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Links(
    @Json(name = "next")
    val next: String
)