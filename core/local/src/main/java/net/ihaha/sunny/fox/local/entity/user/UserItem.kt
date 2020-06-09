package net.ihaha.sunny.fox.local.entity.user


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "UserItem", primaryKeys = ["id"])
data class UserItem(
    @NotNull
    @ColumnInfo(name = "id")
    var id: Int,
    @ColumnInfo(name = "name")
    var name: String? = "",
    @ColumnInfo(name = "username")
    var username: String? = "",
    @ColumnInfo(name = "avatar")
    var avatar: String? = "",
    @ColumnInfo(name = "following")
    var following: Boolean,
    @ColumnInfo(name = "reputation")
    var reputation: String? = "",
    @ColumnInfo(name = "followers_count")
    var followersCount: String? = "",
    @ColumnInfo(name = "posts_count")
    var postsCount: String? = "",
    @ColumnInfo(name = "answers_count")
    var answersCount: String? = "",
    @ColumnInfo(name = "questions_count")
    var questionsCount:  String? = "",
    @ColumnInfo(name = "banned_at")
    var bannedAt: String? = ""
)