package com.example.mydiary.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class ManagerDatabase(context: Context) {
//    val helper = DatabaseHelper(context)
//    var db: SQLiteDatabase? = null
//
//    fun openDb() {
//        db = helper.writableDatabase
//    }
//
//    fun insertToDb(title: String, description: String, imageUri:String) {
//        val values = ContentValues().apply {
//            put(TableDatabase.COLUMN_NAME_TITLE, title)
//            put(TableDatabase.COLUMN_NAME_DESCRIPTION, description)
//            put(TableDatabase.COLUMN_NAME_IMAGE, imageUri)
//        }
//        db?.insert(TableDatabase.TABLE_NAME, null, values)
//    }
//
//    fun readeData(): ArrayList<String> {
//        val dataList = ArrayList<String>()
//        val cursor = db?.query(
//            TableDatabase.TABLE_NAME,
//            null,
//            null,
//            null,
//            null,
//            null,
//            null,
//        )
//        with(cursor) {
//            while (this?.moveToNext()!!) {
//                val dataText = getLong(getColumnIndexOrThrow(TableDatabase.COLUMN_NAME_TITLE))
//                dataList.add(dataText.toString())
//            }
//        }
//        cursor?.close()
//        return dataList
//    }
//
//    fun close() {
//        helper.close()
//    }
}