package net.ihaha.sunny.fox.domain.repository.home

import kotlinx.coroutines.flow.Flow
import net.ihaha.sunny.base.domain.BaseRepository
import net.ihaha.sunny.base.network.remote.Resource
import net.ihaha.sunny.fox.domain.model.home.Categories
import net.ihaha.sunny.fox.domain.utils.Constants

interface NewestRepository : BaseRepository{

    fun fetchNewestAll() : Flow<Resource<List<Categories>>>?

    fun fetchNewestWithParameter(
        type: String = Constants.PAGE.VALUES.DEFAULT_TYPE,
        sort: String = Constants.PAGE.VALUES.DEFAULT_SORT,
        limit: Int = Constants.PAGE.VALUES.DEFAUlT_LIMIT,
        offset: Int = Constants.PAGE.VALUES.DEFAULT_OFF_SET
    ) : Flow<Resource<List<Categories>>>?
}