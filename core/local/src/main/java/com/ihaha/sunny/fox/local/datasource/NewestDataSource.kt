package com.ihaha.sunny.fox.local.datasource

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.ihaha.sunny.fox.local.entity.categories.Newest
import com.ihaha.sunny.fox.local.room.categories.NewestDao

class NewestDataSource constructor(private val newestDao: NewestDao) {

    suspend fun persistNewest(dbNewest: Newest) = withContext(Dispatchers.IO){
        newestDao.save(dbNewest)
    }

    suspend fun persistNewestListSync(dbNewestList: List<Newest>, shouldSynchronize: Boolean = false){
        withContext(Dispatchers.Default){
            withContext(Dispatchers.IO){
                if(shouldSynchronize){
                    newestDao.synchronizeBlocking(dbNewestList)
                }else{
                    newestDao.saveAll(dbNewestList)
                }
            }
        }
    }

}