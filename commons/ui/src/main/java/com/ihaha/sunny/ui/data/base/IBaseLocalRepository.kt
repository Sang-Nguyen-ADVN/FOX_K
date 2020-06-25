package com.ihaha.sunny.ui.data.base

interface IBaseLocalRepository<out L : ILocalDataSource> {
    val localDataSource: L
}
