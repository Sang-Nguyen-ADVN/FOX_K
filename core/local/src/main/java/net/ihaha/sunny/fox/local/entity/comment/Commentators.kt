package net.ihaha.sunny.fox.local.entity.comment

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "commentators", primaryKeys = ["_commentators_id"])
data class Commentators(
    @NotNull
    @ColumnInfo(name = "_commentators_id")
    var id: Int,
    @ColumnInfo(name = "_commentators_avatar")
    var avatar: String?= "",
    @ColumnInfo(name = "_commentators_banned_at")
    var bannedAt: String? = "",
    @ColumnInfo(name = "_commentators_followers_count")
    var followersCount: Int? = 0,
    @ColumnInfo(name = "_commentators_name")
    var name: String? = "",
    @ColumnInfo(name = "_commentators_posts_count")
    var postsCount: Int? = 0,
    @ColumnInfo(name = "_commentators_reputation")
    var reputation: Int? = 0,
    @ColumnInfo(name = "_commentators_url")
    var url: String? = "",
    @ColumnInfo(name = "_commentators_username")
    var username: String? = ""
)