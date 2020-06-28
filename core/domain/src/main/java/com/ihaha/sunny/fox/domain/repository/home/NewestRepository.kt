package com.ihaha.sunny.fox.domain.repository.home

import kotlinx.coroutines.flow.Flow
import com.ihaha.sunny.base.domain.BaseRepository
import com.ihaha.sunny.base.network.remote.DataState
import com.ihaha.sunny.fox.domain.model.home.Categories
import com.ihaha.sunny.fox.domain.utils.Constants

interface NewestRepository : BaseRepository{

    fun fetchNewestAll() : Flow<DataState<List<Categories>>>?

    fun fetchNewestWithParameter(
        type: String = Constants.PAGE.VALUES.DEFAULT_TYPE,
        sort: String = Constants.PAGE.VALUES.DEFAULT_SORT,
        limit: Int = Constants.PAGE.VALUES.DEFAUlT_LIMIT,
        offset: Int = Constants.PAGE.VALUES.DEFAULT_OFF_SET
    ) : Flow<DataState<List<Categories>>>?
}