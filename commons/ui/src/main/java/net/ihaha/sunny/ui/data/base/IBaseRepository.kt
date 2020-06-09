package net.ihaha.sunny.ui.data.base

interface IBaseRepository<out L : ILocalDataSource, out R : IRemoteDataSource> :
    IBaseLocalRepository<L>, IBaseRemoteRepository<R>
