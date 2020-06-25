package com.ihaha.sunny.fox.local.entity.user

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user", primaryKeys = ["_user_id"])
data class User(
    @NonNull
    @ColumnInfo(name = "_user_id")
    var id: Int,
    @ColumnInfo(name = "_user_name")
    var name: String? = "",
    @ColumnInfo(name = "_user_url")
    var url: String? = "",
    @ColumnInfo(name = "_user_username")
    var username: String? = "",
    @ColumnInfo(name = "_user_avatar")
    var avatar: String? = "",
    @ColumnInfo(name = "_user_following")
    var following: Boolean? = false,
    @ColumnInfo(name = "_user_reputation")
    var reputation: String? = "",
    @ColumnInfo(name = "_user_followers_count")
    var followersCount: String? = "",
    @ColumnInfo(name = "_user_posts_count")
    var postsCount: String? = "",
    @ColumnInfo(name = "_user_answers_count")
    var answersCount: String? = "",
    @ColumnInfo(name = "_user_questions_count")
    var questionsCount:  String? = "",
    @ColumnInfo(name = "_user_banned_at")
    var bannedAt: String? = ""
)