package net.ihaha.sunny.fox.data.repository.mappers

import net.ihaha.sunny.fox.local.entity.user.UserItem as DbUserItem
import net.ihaha.sunny.fox.remote.models.user.UserItem

internal fun UserItem.toDbUserItem() : DbUserItem{
    return DbUserItem(
        id = this.id,
        avatar = this.avatar,
        bannedAt = this.bannedAt,
        reputation = this.reputation,
        username = this.username,
        postsCount = this.postsCount,
        name = this.name,
        followersCount = this.followersCount,
        questionsCount = this.questionsCount,
        following = this.following,
        answersCount = this.answersCount
    )
}