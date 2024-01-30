package com.bbeniful.mviandcademo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DemoDao {

    @Query("SELECT * FROM demomodel")
    fun getAll(): Flow<List<DemoModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveOrEdit(demoModel: DemoModel)

    @Delete
    fun delete(demoModel: DemoModel)

}
