package net.ihaha.sunny.ui.data.base

interface IBaseRemoteRepository<out R : IRemoteDataSource> {
    val remoteDataSource: R
}
