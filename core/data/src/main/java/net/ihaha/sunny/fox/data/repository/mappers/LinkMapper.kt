package net.ihaha.sunny.fox.data.repository.mappers

import net.ihaha.sunny.fox.remote.models.paging.Links
import net.ihaha.sunny.fox.local.entity.paging.Links as DbLinks

internal fun Links.toDbLinks() : DbLinks{
    return DbLinks(
        next = this.next
    )
}