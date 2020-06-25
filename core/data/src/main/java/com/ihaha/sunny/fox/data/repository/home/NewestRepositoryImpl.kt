package com.ihaha.sunny.fox.data.repository.home

import com.haroldadmin.cnradapter.executeWithRetry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import com.ihaha.sunny.base.network.remote.Resource
import com.ihaha.sunny.base.network.remote.pairOf
import com.ihaha.sunny.base.network.resource.SingleFetchNetworkBoundResource
import com.ihaha.sunny.base.network.resource.singleFetchNetworkBoundResourceLazy
import com.ihaha.sunny.fox.local.entity.categories.Newest as DbNewest
import com.ihaha.sunny.fox.remote.models.categories.Newest as ApiNewest
import com.ihaha.sunny.fox.local.room.categories.NewestDao
import com.ihaha.sunny.fox.remote.api.ApiServices
import com.ihaha.sunny.fox.domain.utils.Constants
import com.ihaha.sunny.fox.data.mappers.toDbNewest
import com.ihaha.sunny.fox.domain.model.home.Categories
import com.ihaha.sunny.fox.domain.repository.home.NewestRepository
import com.ihaha.sunny.fox.local.datasource.NewestDataSource
import com.ihaha.sunny.fox.remote.models.base.ErrorResponse

class NewestRepositoryImpl constructor(
    private val newestDao: NewestDao,
    private val apiServices: ApiServices,
    private val newestDataSource: NewestDataSource
) : NewestRepository{
    //region variable
    private val defaultLimit = Constants.PAGE.VALUES.DEFAUlT_LIMIT
    private val defaultOffSet = Constants.PAGE.VALUES.DEFAULT_OFF_SET
    private var defaultPageType = Constants.PAGE.VALUES.DEFAULT_TYPE
    private var defaultPageSort = Constants.PAGE.VALUES.DEFAULT_SORT
    //endregion

    //region init
    private fun initHashMapParameter(type: String, sort: String, limit: Int, offset: Int) : HashMap<String, String>{
        val hashMap = HashMap<String, String>()
        hashMap[Constants.PAGE.KEYS.TYPE] = type
        hashMap[Constants.PAGE.KEYS.SORT] = sort
        hashMap[Constants.PAGE.KEYS.LIMIT] = limit.toString()
        hashMap[Constants.PAGE.KEYS.OFFSET] = offset.toString()
        return hashMap
    }

    private fun initialParams(): Pair<Int, Int> = pairOf(defaultLimit, defaultOffSet)
    //endregion

    //region method

    @ExperimentalCoroutinesApi
    private val newestRes: SingleFetchNetworkBoundResource<List<DbNewest>, List<ApiNewest>, ErrorResponse> by singleFetchNetworkBoundResourceLazy(
        initialParams = ::initialParams,
        dataToDatabase = { _, dbLimit, dbOffSet -> fetchNewestFromCached(defaultPageType, defaultPageSort, dbLimit, dbOffSet)},
        cacheValidator = { cachedNewest -> !cachedNewest.isNullOrEmpty()},
        dataToServer = { fetchNewestFromService(initHashMapParameter(defaultPageType, defaultPageSort, defaultLimit, defaultOffSet)) },
        dataToPersist = { newestData -> newestDataSource.persistNewestListSync(newestData.map { it.toDbNewest() })}
    )

    @ExperimentalCoroutinesApi
    override fun fetchNewestAll(): Flow<Resource<List<Categories>>>? {
        return null
    }

    @ExperimentalCoroutinesApi
    override fun fetchNewestWithParameter(
        type: String,
        sort: String,
        limit: Int,
        offset: Int
    ): Flow<Resource<List<Categories>>>? {
        newestRes.updateParams(limit, offset)
        val data = newestRes.flow()
        return null
    }

    private suspend fun fetchNewestFromCached(type: String, sort: String, limit: Int, offset: Int) = withContext(Dispatchers.IO){
        newestDao.forQueryWithType(type, sort, limit, offset)
    }

    private suspend fun fetchNewestFromService(hashMap: HashMap<String, String>) = withContext(Dispatchers.IO){
        executeWithRetry {
            apiServices.getNewestAsync(hashMap).await()
        }
    }

    //endregion


}


