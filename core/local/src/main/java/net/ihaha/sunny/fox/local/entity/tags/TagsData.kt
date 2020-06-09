package net.ihaha.sunny.fox.local.entity.tags
import androidx.room.ColumnInfo
import androidx.room.Embedded

data class TagsData(
    @Embedded
    var result : Tags? = null
)