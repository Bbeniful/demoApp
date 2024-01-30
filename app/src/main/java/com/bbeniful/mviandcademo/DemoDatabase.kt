package com.bbeniful.mviandcademo

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DemoModel::class], version = 1, exportSchema = false)
abstract class DemoDatabase : RoomDatabase() {

    abstract fun dao(): DemoDao

    companion object {
        const val DATABASE_NAME = "demo_db"
    }
}