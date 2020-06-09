package net.ihaha.sunny.fox.local.entity.paging


import androidx.room.ColumnInfo
import androidx.room.Entity

//@Entity(tableName = "links", primaryKeys = ["id"])
data class Links(
    @ColumnInfo(name = "next")
    var next: String
)