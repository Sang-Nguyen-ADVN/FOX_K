package net.ihaha.sunny.fox.remote.models.paging


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Pagination(
    @Json(name = "total")
    val total: String? = "0",
    @Json(name = "count")
    val count: String? = "0",
    @Json(name = "per_page")
    val perPage: String? = "0",
    @Json(name = "current_page")
    val currentPage: String? = "0",
    @Json(name = "total_pages")
    val totalPages: String? = "0",
    @Json(name = "links")
    val links: Links
)