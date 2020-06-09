package net.ihaha.sunny.fox.data.repository.mappers

import net.ihaha.sunny.fox.remote.models.paging.Meta
import net.ihaha.sunny.fox.local.entity.paging.Meta as DbMeta

internal fun Meta.toDbMeta() : DbMeta{
    return DbMeta(
        pagination = this.pagination.toDbPagination()
    )
}