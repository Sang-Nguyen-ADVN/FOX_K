package net.ihaha.sunny.fox.local.entity.comment
import androidx.room.ColumnInfo
import androidx.room.Embedded

data class CommentatorsData(
    @Embedded
    var result : Commentators? = null
)