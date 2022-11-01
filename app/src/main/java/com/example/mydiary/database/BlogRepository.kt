package com.example.mydiary.database

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class BlogRepository(private val dao: Dao) {
    val blogs: Flow<List<Entity>> = dao.getAll()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(blog: Entity) {
        dao.insert(blog)
    }
}