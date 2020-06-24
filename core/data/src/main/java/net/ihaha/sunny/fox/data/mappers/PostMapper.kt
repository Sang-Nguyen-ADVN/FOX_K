package net.ihaha.sunny.fox.data.mappers

import net.ihaha.sunny.fox.local.entity.posts.Posts as DbPosts
import net.ihaha.sunny.fox.remote.models.posts.Posts

internal fun Posts.toDbPost(): DbPosts{
    return DbPosts(
        id = this.id,
        canonicalUrl = this.canonicalUrl,
        path = this.path,
//        tags = this.tags?,
        title = this.title,
        user = this.user?.toDbUser()
    )
}