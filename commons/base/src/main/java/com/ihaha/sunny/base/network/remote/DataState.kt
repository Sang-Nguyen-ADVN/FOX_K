package com.ihaha.sunny.base.network.remote

/**
 * A sealed class to represent UI states associated with a resource.
 */
sealed class DataState<out T>( var loading: Boolean,
                               var stateMessage: StateMessage? = null) {

    abstract override fun hashCode(): Int
    abstract override fun equals(other: Any?): Boolean

    /**
     * A property to determine whether this Resource has reached a terminal status or not.
     * A Resource is in a terminal status if it is [Success] or [Error]
     */
    abstract val isComplete: Boolean

    /**
     * A data class to represent the scenario where the resource is available without any errors
     *
     * This is a terminal state, and the Resource object is considered to be completed when it is in this state
     */
    data class SUCCESS <out T>(
        val data: T,
        val isCached: Boolean = false,
        val dataType: DataType = DataType.UNKNOW,
        val message: StateMessage? = null)
        : DataState<T>(loading = !isCached, stateMessage = message) {

        override val isComplete: Boolean = !isCached

        operator fun invoke(): T { return data }
    }

    /**
     * A data class to represent the scenario where a resource may or may not be available due to an error
     *
     * This is a terminal state, and the Resource object is considered to be completed when it is in this state
     */
    data class ERROR <out T, out E> (
        val data: T?,
        val error: E?,
        val dataType: DataType = DataType.UNKNOW,
        val message: StateMessage? = null)
        : DataState<T>(loading = false, stateMessage = message) {

        override val isComplete: Boolean = true
    }

    /**
     * A class to represent the loading state of an object
     *
     * This is a non-terminal state.
     */
    object LOADING : DataState<Nothing>(loading = false) {
        override fun hashCode(): Int {
            return 2
        }

        override fun equals(other: Any?): Boolean {
            return other is LOADING
        }

        override val isComplete: Boolean = false
    }

    object Uninitialized : DataState<Nothing>(loading = false) {
        override fun hashCode(): Int {
            return 1
        }

        override fun equals(other: Any?): Boolean {
            return other is Uninitialized
        }

        override val isComplete: Boolean = false
    }
}

enum class DataType{
    UNKNOW,
    DATABASE,
    REMOTE
}

operator fun <T> DataState<T>.invoke(): T? {
    return when {
        this is DataState.SUCCESS -> this.data
        this is DataState.ERROR<T, *> && this.data != null -> this.data
        else -> null
    }
}