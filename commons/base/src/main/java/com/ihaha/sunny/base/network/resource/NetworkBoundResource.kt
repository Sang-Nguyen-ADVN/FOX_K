package com.ihaha.sunny.base.network.resource

import com.haroldadmin.cnradapter.NetworkResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.ihaha.sunny.base.network.remote.DataState
import com.ihaha.sunny.base.network.remote.DataType

/**
 * Represents a resource which needs to be loaded from the network and persisted to the Database
 *
 * @param T The type of the entity to be fetched/stored in the database
 * @param U The success type of [NetworkResponse]
 * @param V The error type of [NetworkResponse]
 *
 * The items emitted from this class are wrapped in a [DataState] class. The items are emitted in a [Flow].
 * Following is sequence of actions taken:
 * 1. Emit Resource.Loading
 * 2. Query database for cached data using [dataFromDatabase].
 * 3. Emit Cached data from the database, if there is any. The decision to emit data is made using the abstract
 * [validateCache] method.
 * 4. Fetch data from the API using [dataFromServer]
 * 5. If the fetch is successful, persist the data using [dataFromPersist] else emit [DataState.ERROR] with the cached data and terminate
 * 6. Emit [DataState.SUCCESS] with the newly persisted data if the fetch was successful
 *
 * The class also contains two properties [offset] and [limit] so that they can be dynamically updated. They are
 * passed to [dataFromDatabase] on every invocation. They can be updated using the [updateParams] method.
 */
abstract class NetworkBoundResource<T : Any, U : Any, V : Any> {

    protected var offset: Int = 0
    protected var limit: Int = -1

    abstract suspend fun dataFromDatabase(isRefreshed: Boolean, limit: Int, offset: Int): T?
    abstract suspend fun validateCache(cachedData: T?): Boolean
    abstract suspend fun dataFromServer(): NetworkResponse<U, V>
    abstract suspend fun dataFromPersist(apiData: U)

    fun updateParams(limit: Int = this.limit, offset: Int = this.offset) {
        this.offset = offset
        this.limit = limit
    }

    @ExperimentalCoroutinesApi
    open fun flow(): Flow<DataState<T?>> {
        return flow {
            val cachedData = dataFromDatabase(isRefreshed = false, limit = limit, offset = offset)
            if (validateCache(cachedData)) {
                emit(DataState.SUCCESS(data = cachedData, isCached = true, dataType = DataType.DATABASE))
            } else {
                emit(DataState.LOADING)
            }

            when (val apiResponse = dataFromServer()) {
                is NetworkResponse.Success -> {
                    dataFromPersist(apiResponse.body)
                    val refreshedData = dataFromDatabase(isRefreshed = true, limit = limit, offset = offset)!!
                    emit(DataState.SUCCESS(refreshedData, isCached = false, dataType = DataType.REMOTE))
                }
                is NetworkResponse.ServerError -> {
                    val error = apiResponse.body
                    emit(DataState.ERROR(cachedData, error))
                }
                is NetworkResponse.NetworkError -> {
                    val error = apiResponse.error
                    emit(DataState.ERROR(cachedData, error))
                }
            }
        }
    }
}

@ExperimentalCoroutinesApi
inline fun <T : Any, U : Any, V : Any> networkBoundResource(
    crossinline initialParams: () -> Pair<Int, Int> = { -1 to 0 },
    crossinline dbFetcher: suspend (Boolean, Int, Int) -> T?,
    crossinline apiFetcher: suspend () -> NetworkResponse<U, V>,
    crossinline cacheValidator: suspend (T?) -> Boolean,
    crossinline dataPersist: suspend (U) -> Unit
): NetworkBoundResource<T, U, V> {
    return object : NetworkBoundResource<T, U, V>() {
        init {
            val (limit, offset) = initialParams()
            updateParams(limit, offset)
        }

        override suspend fun dataFromDatabase(isRefreshed: Boolean, limit: Int, offset: Int): T? {
            return dbFetcher(isRefreshed, limit, offset)
        }

        override suspend fun validateCache(cachedData: T?): Boolean {
            return cacheValidator(cachedData)
        }

        override suspend fun dataFromServer(): NetworkResponse<U, V> {
            return apiFetcher()
        }

        override suspend fun dataFromPersist(apiData: U) {
            dataPersist(apiData)
        }
    }
}

@ExperimentalCoroutinesApi
inline fun <T : Any, U : Any, V : Any> networkBoundFlow(
    crossinline initialParams: () -> Pair<Int, Int> = { -1 to 0 },
    crossinline dataToDatabase: suspend (Boolean, Int, Int) -> T?,
    crossinline dataToServer: suspend () -> NetworkResponse<U, V>,
    crossinline cacheValidator: suspend (T?) -> Boolean,
    crossinline dataToPersist: suspend (U) -> Unit
): Flow<DataState<T?>> {
    val resource = networkBoundResource(initialParams, dataToDatabase, dataToServer, cacheValidator, dataToPersist)
    return resource.flow()
}

@ExperimentalCoroutinesApi
inline fun <T : Any, U : Any, V : Any> networkBoundResourceLazy(
    crossinline initialParams: () -> Pair<Int, Int> = { -1 to 0 },
    crossinline dataToDatabase: suspend (Boolean, Int, Int) -> T?,
    crossinline dataToServer: suspend () -> NetworkResponse<U, V>,
    crossinline cacheValidator: suspend (T?) -> Boolean,
    crossinline dataToPersist: suspend (U) -> Unit
): Lazy<NetworkBoundResource<T, U, V>> {
    return lazyOf(networkBoundResource(initialParams, dataToDatabase, dataToServer, cacheValidator, dataToPersist))
}
