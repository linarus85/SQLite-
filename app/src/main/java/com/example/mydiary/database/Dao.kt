package com.example.mydiary.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert()
     fun insert(blog: Entity)

    @Query("SELECT * FROM blog")
    fun getAll(): Flow<List<Entity>>

    @Query("DELETE FROM blog")
     fun deleteAll()
}