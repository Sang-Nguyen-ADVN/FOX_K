package net.ihaha.sunny.fox.remote.models.base

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import net.ihaha.sunny.fox.remote.models.paging.Meta


/**
 * Created by Sunny on 28/11/2019.
 * Version 1.1
 */
@JsonClass(generateAdapter = true)
data class ResultResponse<T>(
    @Json(name = "data")
    val result: List<T>? = null,
    @Json(name = "meta")
    val meta: Meta
)