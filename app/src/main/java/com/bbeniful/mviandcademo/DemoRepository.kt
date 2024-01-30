package com.bbeniful.mviandcademo

import kotlinx.coroutines.flow.Flow

interface DemoRepository {

    fun getAll():Flow<List<DemoModel>>

    fun saveOrEdit(demoModel: DemoModel)

    fun delete(demoModel: DemoModel)
}