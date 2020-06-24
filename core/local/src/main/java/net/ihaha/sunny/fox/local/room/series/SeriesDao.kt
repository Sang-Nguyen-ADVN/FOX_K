package net.ihaha.sunny.fox.local.room.series

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.runBlocking
import net.ihaha.sunny.base.data.BaseDao
import net.ihaha.sunny.fox.local.entity.series.Series

@Dao
abstract class SeriesDao : BaseDao<Series> {

    @Query("SELECT * FROM Series ORDER BY id DESC")
    abstract suspend fun forId() : Series

    @Query("SELECT * FROM Series ORDER BY title LIMIT :limit OFFSET :offset")
    abstract suspend fun forAll(limit: Int, offset: Int) : List<Series>

    @Query("SELECT * FROM Series WHERE title ORDER BY title LIKE :query LIMIT :limit OFFSET :offset")
    abstract suspend fun forQuery(query: String, limit: Int, offset: Int) : List<Series>

    @Query("DELETE FROM Series")
    abstract suspend fun clear()

    @Transaction
    open fun synchronizeBlocking(items: List<Series>) = runBlocking {
        clear()
        saveAll(items)
    }
}