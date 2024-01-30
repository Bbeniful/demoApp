package com.bbeniful.mviandcademo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DemoModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val language: String,
    val level: String
)
