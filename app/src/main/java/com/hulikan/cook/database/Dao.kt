package com.hulikan.cook.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MainDao {
    @Query("SELECT * FROM mainlist")
    fun getAll() : Flow<List<MainList>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(editEntity : MainList)
    @Delete
    suspend fun deleteList(editEntity : MainList)
    @Query("DELETE FROM mainlist")
    suspend fun deleteAll()

}