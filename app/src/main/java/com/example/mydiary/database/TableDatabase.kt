package com.example.mydiary.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Entity::class], version = 11)
abstract class TableDatabase : RoomDatabase() {
    abstract fun dao(): Dao

    companion object {
        fun getDb(context: Context): TableDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                TableDatabase::class.java,
                "table.db"
            ).build()
        }
    }

}