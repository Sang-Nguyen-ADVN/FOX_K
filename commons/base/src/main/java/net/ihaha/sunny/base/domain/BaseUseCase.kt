package net.ihaha.sunny.base.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface BaseUseCase{
    suspend fun execute(dispatcher: CoroutineDispatcher = Dispatchers.IO): Any
}
