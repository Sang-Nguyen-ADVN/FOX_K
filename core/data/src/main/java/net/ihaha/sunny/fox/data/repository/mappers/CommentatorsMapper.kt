package net.ihaha.sunny.fox.data.repository.mappers

import net.ihaha.sunny.fox.remote.models.comment.Commentators
import net.ihaha.sunny.fox.local.entity.comment.Commentators as DbCommentators


internal fun Commentators.toDbCommentators() : DbCommentators{
    return DbCommentators(
        id = this.id,
        url = this.url,
        followersCount = this.followersCount,
        name = this.name,
        postsCount = this.postsCount,
        username = this.username,
        reputation = this.reputation,
        bannedAt = this.bannedAt,
        avatar = this.avatar
    )
}