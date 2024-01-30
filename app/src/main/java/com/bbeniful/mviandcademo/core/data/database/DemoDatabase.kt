package com.bbeniful.mviandcademo.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bbeniful.mviandcademo.core.data.database.dao.DemoDao
import com.bbeniful.mviandcademo.DemoModel

@Database(entities = [DemoModel::class], version = 1, exportSchema = false)
abstract class DemoDatabase : RoomDatabase() {

    abstract fun dao(): DemoDao

    companion object {
        const val DATABASE_NAME = "demo_db"
    }
}