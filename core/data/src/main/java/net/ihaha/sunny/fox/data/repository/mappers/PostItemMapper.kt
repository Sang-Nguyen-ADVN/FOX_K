package net.ihaha.sunny.fox.data.repository.mappers

import net.ihaha.sunny.fox.remote.models.posts.PostsItem
import net.ihaha.sunny.fox.local.entity.posts.PostsItem as DbPostsItem

internal fun PostsItem.toDbPostItem() : DbPostsItem{
    return DbPostsItem(
        id = this.id,
        user = this.user?.toDbUserPost(),
        title = this.title,
        path = this.path,
        canonicalUrl = this.canonicalUrl
    )
}