package com.ihaha.sunny.fox.data.mappers

import com.ihaha.sunny.fox.local.entity.paging.Pagination as DbPagination
import com.ihaha.sunny.fox.remote.models.paging.Pagination

internal fun Pagination.toDbPagination() : DbPagination{
    return DbPagination(
        total = this.total,
        count = this.count,
        currentPage = this.currentPage,
        links = this.links.toDbLinks(),
        perPage = this.perPage,
        totalPages = this.totalPages
    )
}