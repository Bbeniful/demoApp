package com.bbeniful.mviandcademo.repository

import com.bbeniful.mviandcademo.DemoModel
import com.bbeniful.mviandcademo.core.domain.repositories.DemoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeRepository : DemoRepository {
    var savableDemoModel: DemoModel? = null
    var deleteDemoModel: DemoModel? = null
    override fun getAll(): Flow<List<DemoModel>> {
        val testData = listOf(
            DemoModel(id = 0, name = "1", language = "lan1", level = "1"),
            DemoModel(id = 1, name = "2", language = "lan2", level = "2"),
            DemoModel(id = 2, name = "3", language = "lan3", level = "3")
        )
        return flow {
            emit(testData)
        }
    }

    override fun saveOrEdit(demoModel: DemoModel) {
        this.savableDemoModel = demoModel
    }

    override fun delete(demoModel: DemoModel) {
        this.deleteDemoModel = demoModel
    }
}