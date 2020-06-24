package net.ihaha.sunny.fox.local.room.categories

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.runBlocking
import net.ihaha.sunny.base.data.BaseDao
import net.ihaha.sunny.fox.local.entity.categories.Videos

@Dao
abstract class VideosDao : BaseDao<Videos> {

    @Query("SELECT * FROM Videos ORDER BY id DESC")
    abstract suspend fun forId() : Videos

    @Query("SELECT * FROM Videos ORDER BY title LIMIT :limit OFFSET :offset")
    abstract suspend fun forAll(limit: Int, offset: Int) : List<Videos>

    @Query("SELECT * FROM Videos WHERE title ORDER BY title LIKE :query LIMIT :limit OFFSET :offset")
    abstract suspend fun forQuery(query: String, limit: Int, offset: Int) : List<Videos>

    @Query("DELETE FROM Videos")
    abstract suspend fun clear()

    @Transaction
    open fun synchronizeBlocking(items: List<Videos>) = runBlocking {
        clear()
        saveAll(items)
    }
}