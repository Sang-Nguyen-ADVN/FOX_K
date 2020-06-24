package net.ihaha.sunny.fox.local.room.organization

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.runBlocking
import net.ihaha.sunny.base.data.BaseDao
import net.ihaha.sunny.fox.local.entity.organizations.Organizations

@Dao
abstract class OrganizationsDao :
    BaseDao<Organizations> {

    @Query("SELECT * FROM organizations ORDER BY id DESC")
    abstract suspend fun forId() : Organizations

    @Query("SELECT * FROM organizations ORDER BY name LIMIT :limit OFFSET :offset")
    abstract suspend fun forAll(limit: Int, offset: Int) : List<Organizations>

    @Query("SELECT * FROM organizations WHERE name ORDER BY name LIKE :query LIMIT :limit OFFSET :offset")
    abstract suspend fun forQuery(query: String, limit: Int, offset: Int) : List<Organizations>

    @Query("DELETE FROM organizations")
    abstract suspend fun clear()

    @Transaction
    open fun synchronizeBlocking(items: List<Organizations>) = runBlocking {
        clear()
        saveAll(items)
    }
}