package com.ihaha.sunny.fox.data.mappers

import com.ihaha.sunny.fox.remote.models.categories.Newest
import com.ihaha.sunny.fox.local.entity.categories.Newest as DbNewest


internal fun Newest.toDbNewest() : DbNewest {
    return DbNewest(
        id = this.id,
        title = this.title,
        clipsCount = this.clipsCount,
        commentsCount = this.commentsCount,
        contentsShort = this.contentsShort,
        isPublished = this.isPublished,
        points = this.points,
        publishedAt = this.publishedAt,
        ratedValue = this.ratedValue,
        readingTime = this.readingTime,
        thumbnailUrl = this.thumbnailUrl,
        updatedAt = this.updatedAt,
        url = this.url,
        user_Id = this.user_Id,
        viewsCount = this.viewsCount,

        user = this.user?.toDbUserData()
    )
}