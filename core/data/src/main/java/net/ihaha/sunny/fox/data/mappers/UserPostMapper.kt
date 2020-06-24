package net.ihaha.sunny.fox.data.mappers

import net.ihaha.sunny.fox.local.entity.user.UserPost as DbUserPost
import net.ihaha.sunny.fox.remote.models.user.UserPost

internal fun UserPost.toDbUserPost() : DbUserPost{
    return DbUserPost(
        userPostItem = this.userPostItem.toDbUserPostItem()
    )
}