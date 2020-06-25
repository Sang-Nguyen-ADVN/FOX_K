package com.ihaha.sunny.fox.local.room.tags

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.runBlocking
import com.ihaha.sunny.base.data.BaseDao
import com.ihaha.sunny.fox.local.entity.tags.Tags

@Dao
abstract class TagsDao : BaseDao<Tags> {

    @Query("SELECT * FROM Tags ORDER BY _tag_id DESC")
    abstract suspend fun forId() : Tags

    @Query("SELECT * FROM Tags ORDER BY _tag_name LIMIT :limit OFFSET :offset")
    abstract suspend fun forAll(limit: Int, offset: Int) : List<Tags>

    @Query("SELECT * FROM Tags WHERE _tag_name ORDER BY _tag_name LIKE :query LIMIT :limit OFFSET :offset")
    abstract suspend fun forQuery(query: String, limit: Int, offset: Int) : List<Tags>

    @Query("DELETE FROM Tags")
    abstract suspend fun clear()

    @Transaction
    open fun synchronizeBlocking(items: List<Tags>) = runBlocking {
        clear()
        saveAll(items)
    }
}