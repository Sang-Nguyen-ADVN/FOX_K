package net.ihaha.sunny.fox.local.entity.paging


import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity

//@Entity(tableName = "pagination", primaryKeys = ["id"])
data class Pagination(
    @ColumnInfo(name = "total")
    var total: String? = "0",
    @ColumnInfo(name = "count")
    var count: String? = "0",
    @ColumnInfo(name = "per_page")
    var perPage: String? = "0",
    @ColumnInfo(name = "current_page")
    var currentPage: String? = "0",
    @ColumnInfo(name = "total_pages")
    var totalPages: String? = "0",
    @Embedded(prefix = "links")
    @ColumnInfo(name = "links")
    var links: Links
)