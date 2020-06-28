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
abstract class NetworkBoundResourceNoCache<U : Any, V : Any> {

    abstract suspend fun dataFromServer(): NetworkResponse<U, V>

    @ExperimentalCoroutinesApi
    open fun flow(): Flow<DataState<U>> {
        return flow {
            emit(DataState.LOADING)

            when (val apiResponse = dataFromServer()) {
                is NetworkResponse.Success -> {
                    emit(
                        DataState.SUCCESS(
                            apiResponse.body,
                            isCached = false,
                            dataType = DataType.REMOTE
                        )
                    )
                }
                is NetworkResponse.ServerError -> {
                    val error = apiResponse.body
                    emit(DataState.ERROR(null, error))
                }
                is NetworkResponse.NetworkError -> {
                    val error = apiResponse.error
                    emit(DataState.ERROR(null, error))
                }
            }
        }
    }
}

@ExperimentalCoroutinesApi
inline fun <U : Any, V : Any> networkBoundResourceNoCache(
    crossinline dataToServer: suspend () -> NetworkResponse<U, V>
): NetworkBoundResourceNoCache<U, V> {
    return object : NetworkBoundResourceNoCache<U, V>() {

        override suspend fun dataFromServer(): NetworkResponse<U, V> {
            return dataToServer()
        }
    }
}

@ExperimentalCoroutinesApi
inline fun <U : Any, V : Any> networkBoundFlowNoCache(
    crossinline dataToServer: suspend () -> NetworkResponse<U, V>
): Flow<DataState<U?>> {
    val resource = networkBoundResourceNoCache(dataToServer)
    return resource.flow()
}

@ExperimentalCoroutinesApi
inline fun <U : Any, V : Any> networkBoundResourceNoCacheLazy(
    crossinline dataToServer: suspend () -> NetworkResponse<U, V>
): Lazy<NetworkBoundResourceNoCache<U, V>> {
    return lazyOf(networkBoundResourceNoCache(dataToServer))
}
