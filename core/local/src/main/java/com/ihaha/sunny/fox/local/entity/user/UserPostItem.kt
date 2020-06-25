package com.ihaha.sunny.fox.local.entity.user


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_post_item", primaryKeys = ["id"])
data class UserPostItem(
    @ColumnInfo(name = "id")
    var id: Int,
    @ColumnInfo(name = "name")
    var name: String? = "",
    @ColumnInfo(name = "username")
    var username: String? = "",
    @ColumnInfo(name = "avatar")
    var avatar: String? = "",
    @ColumnInfo(name = "following")
    var following: Boolean? = true,
    @ColumnInfo(name = "reputation")
    var reputation: String? = "0",
    @ColumnInfo(name = "followers_count")
    var followersCount: String? = "0",
    @ColumnInfo(name = "posts_count")
    var postsCount: String? = "0",
    @ColumnInfo(name = "answers_count")
    var answersCount: String? = "0",
    @ColumnInfo(name = "questions_count")
    var questionsCount: String? = "0",
    @ColumnInfo(name = "banned_at")
    var bannedAt: String? = ""
)