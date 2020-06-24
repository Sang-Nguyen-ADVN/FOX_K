package net.ihaha.sunny.fox.data.mappers

import net.ihaha.sunny.fox.local.entity.tags.Tags  as DbTags
import net.ihaha.sunny.fox.remote.models.tags.Tags

internal fun Tags.toDbTags() : DbTags{
    return DbTags(
        id = this.id,
        questionsCount = this.questionsCount,
        postsCount = this.postsCount,
        name = this.name,
        followersCount = this.followersCount,
        url = this.url,
        image = this.image,
        primary = this.primary,
        slug = this.slug
    )
}