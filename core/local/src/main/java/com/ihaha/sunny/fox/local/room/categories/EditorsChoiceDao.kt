package com.ihaha.sunny.fox.local.room.categories

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.runBlocking
import com.ihaha.sunny.base.data.BaseDao
import com.ihaha.sunny.fox.local.entity.categories.EditorsChoice

@Dao
abstract class EditorsChoiceDao :
    BaseDao<EditorsChoice> {

    @Query("SELECT * FROM editors_choice ORDER BY id DESC")
    abstract suspend fun forId() : EditorsChoice

    @Query("SELECT * FROM editors_choice ORDER BY title LIMIT :limit OFFSET :offset")
    abstract suspend fun forAll(limit: Int, offset: Int) : List<EditorsChoice>

    @Query("SELECT * FROM editors_choice WHERE title ORDER BY title LIKE :query LIMIT :limit OFFSET :offset")
    abstract suspend fun forQuery(query: String, limit: Int, offset: Int) : List<EditorsChoice>

    @Query("DELETE FROM editors_choice")
    abstract suspend fun clear()

    @Transaction
    open fun synchronizeBlocking(items: List<EditorsChoice>) = runBlocking {
        clear()
        saveAll(items)
    }
}