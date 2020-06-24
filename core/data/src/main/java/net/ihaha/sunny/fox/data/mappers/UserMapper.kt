package net.ihaha.sunny.fox.data.mappers

import net.ihaha.sunny.fox.local.entity.user.User as DbUser
import net.ihaha.sunny.fox.remote.models.user.User


internal fun User.toDbUser() : DbUser {
    return DbUser(
        id = this.id,
        url = this.url,
        answersCount = this.url,
        avatar = this.avatar,
        bannedAt = this.bannedAt,
        followersCount = this.followersCount,
        following = this.following,
        name = this.name,
        postsCount = this.postsCount,
        questionsCount = this.questionsCount,
        reputation = this.reputation,
        username = this.username
    )
}