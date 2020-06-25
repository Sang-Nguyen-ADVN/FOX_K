package com.ihaha.sunny.fox.remote.models.paging


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Meta(
    @Json(name = "pagination")
    val pagination: Pagination
)