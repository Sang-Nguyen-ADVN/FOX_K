package com.ihaha.sunny.fox.local.entity.paging


import androidx.room.ColumnInfo
import androidx.room.Entity

//@Entity(tableName = "meta", primaryKeys = ["id"])
data class Meta(
    @ColumnInfo(name = "pagination")
    var pagination: Pagination
)