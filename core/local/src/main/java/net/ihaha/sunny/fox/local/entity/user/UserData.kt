package net.ihaha.sunny.fox.local.entity.user
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

data class UserData(
    @Embedded
    var user : User? = null
)