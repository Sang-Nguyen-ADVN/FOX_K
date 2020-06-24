package net.ihaha.sunny.fox.local.room.categories

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.runBlocking
import net.ihaha.sunny.base.data.BaseDao
import net.ihaha.sunny.fox.local.entity.categories.Newest

@Dao
abstract class NewestDao : BaseDao<Newest> {

    @Query("SELECT * FROM newest ORDER BY id DESC")
    abstract suspend fun forId() : Newest

    @Query("SELECT * FROM newest ORDER BY id LIMIT :limit OFFSET :offset")
    abstract suspend fun forAll(limit: Int, offset: Int) : List<Newest>

    @Query("""
            SELECT * 
            FROM newest 
            WHERE page_type =:type AND  page_sort =:sort
            ORDER BY id ASC 
            LIMIT :limit 
            OFFSET :offset""")
    abstract suspend fun forQueryWithType(type: String, sort: String, limit: Int, offset: Int) : List<Newest>

    @Query("DELETE FROM newest")
    abstract suspend fun clear()

    @Transaction
    open fun synchronizeBlocking(items: List<Newest>) = runBlocking {
        clear()
        saveAll(items)
    }
}