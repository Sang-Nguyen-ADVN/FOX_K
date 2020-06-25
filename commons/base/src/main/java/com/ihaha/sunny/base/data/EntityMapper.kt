package com.ihaha.sunny.base.data

/**
 * Interface for model mappers. It provides helper methods that facilitate
 * retrieving of models from outer data source layers
 *
 * @param <CACHED> the cached model input type
 * @param <ENTITY> the model return type
 */
interface EntityMapper<CACHED, ENTITY> {
    fun mapFromCached(type: CACHED): ENTITY
    fun mapToCached(type: ENTITY): CACHED
}
