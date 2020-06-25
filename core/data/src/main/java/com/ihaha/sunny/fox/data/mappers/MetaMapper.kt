package com.ihaha.sunny.fox.data.mappers

import com.ihaha.sunny.fox.remote.models.paging.Meta
import com.ihaha.sunny.fox.local.entity.paging.Meta as DbMeta

internal fun Meta.toDbMeta() : DbMeta{
    return DbMeta(
        pagination = this.pagination.toDbPagination()
    )
}