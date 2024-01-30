package com.bbeniful.mviandcademo.core.domain.repositories

import com.bbeniful.mviandcademo.DemoModel
import kotlinx.coroutines.flow.Flow

interface DemoRepository {

    fun getAll():Flow<List<DemoModel>>

    fun saveOrEdit(demoModel: DemoModel)

    fun delete(demoModel: DemoModel)
}