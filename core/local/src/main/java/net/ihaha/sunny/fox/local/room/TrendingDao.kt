package net.ihaha.sunny.fox.local.room

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.runBlocking
import net.ihaha.sunny.base.data.BaseDao
import net.ihaha.sunny.fox.local.entity.categories.Trending

@Dao
abstract class TrendingDao : BaseDao<Trending> {

    @Query("SELECT * FROM Trending ORDER BY id DESC")
    abstract suspend fun forId() : Trending

    @Query("SELECT * FROM Trending ORDER BY title LIMIT :limit OFFSET :offset")
    abstract suspend fun forAll(limit: Int, offset: Int) : List<Trending>

    @Query("SELECT * FROM Trending WHERE title ORDER BY title LIKE :query LIMIT :limit OFFSET :offset")
    abstract suspend fun forQuery(query: String, limit: Int, offset: Int) : List<Trending>

    @Query("DELETE FROM Trending")
    abstract suspend fun clear()

    @Transaction
    open fun synchronizeBlocking(items: List<Trending>) = runBlocking {
        clear()
        saveAll(items)
    }
}