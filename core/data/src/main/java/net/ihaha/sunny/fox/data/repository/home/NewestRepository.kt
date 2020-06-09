package net.ihaha.sunny.fox.data.repository.home

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.ihaha.sunny.fox.data.repository.mappers.toDbNewest
import net.ihaha.sunny.fox.local.room.NewestDao
import net.ihaha.sunny.fox.remote.models.categories.Newest
import net.ihaha.sunny.fox.local.entity.categories.Newest as DbNewest

class NewestRepository constructor(private val newestDao: NewestDao) {

    suspend fun persistNewest(apiNewest: Newest) = withContext(Dispatchers.IO){
        newestDao.save(apiNewest.toDbNewest())
    }

    suspend fun persistNewest(dbNewest: DbNewest) = withContext(Dispatchers.IO){
        newestDao.save(dbNewest)
    }

    suspend fun persistNewestSync(apiNewest: List<Newest>, shouldSynchronize: Boolean = false){
        withContext(Dispatchers.Default){
            val dbNewest = apiNewest.map { it.toDbNewest() }
            withContext(Dispatchers.IO){
                if(shouldSynchronize){
                    newestDao.synchronizeBlocking(dbNewest)
                }else{
                    newestDao.saveAll(dbNewest)
                }
            }
        }
    }

    @JvmName("persistDbNewest")
    suspend fun persistNewestSync(dbNewest: List<DbNewest>, shouldSynchronize: Boolean = false){
        withContext(Dispatchers.Default){
            withContext(Dispatchers.IO){
                if(shouldSynchronize){
                    newestDao.synchronizeBlocking(dbNewest)
                }else{
                    newestDao.saveAll(dbNewest)
                }
            }
        }
    }

}