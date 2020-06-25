package com.ihaha.sunny.fox.data.mappers

import com.ihaha.sunny.fox.remote.models.posts.PostsItem
import com.ihaha.sunny.fox.local.entity.posts.PostsItem as DbPostsItem

internal fun PostsItem.toDbPostItem() : DbPostsItem{
    return DbPostsItem(
        id = this.id,
        user = this.user?.toDbUserPost(),
        title = this.title,
        path = this.path,
        canonicalUrl = this.canonicalUrl
    )
}