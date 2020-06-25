package com.ihaha.sunny.fox.local.entity.user


import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity

data class UserPost(
    @Embedded
    var userPostItem: UserPostItem? = null
)