package com.ihaha.sunny.fox.data.mappers

import com.ihaha.sunny.fox.remote.models.paging.Links
import com.ihaha.sunny.fox.local.entity.paging.Links as DbLinks

internal fun Links.toDbLinks() : DbLinks{
    return DbLinks(
        next = this.next
    )
}