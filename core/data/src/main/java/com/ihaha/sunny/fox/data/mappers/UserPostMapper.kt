package com.ihaha.sunny.fox.data.mappers

import com.ihaha.sunny.fox.local.entity.user.UserPost as DbUserPost
import com.ihaha.sunny.fox.remote.models.user.UserPost

internal fun UserPost.toDbUserPost() : DbUserPost{
    return DbUserPost(
        userPostItem = this.userPostItem.toDbUserPostItem()
    )
}