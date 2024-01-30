package com.bbeniful.mviandcademo.core.data.repositories

import com.bbeniful.mviandcademo.DemoModel
import com.bbeniful.mviandcademo.core.domain.repositories.DemoRepository
import com.bbeniful.mviandcademo.core.data.database.dao.DemoDao
import javax.inject.Inject

class DemoRepositoryImpl @Inject constructor(
    private val dao: DemoDao
) : DemoRepository {

    override fun getAll() = dao.getAll()

    override fun saveOrEdit(demoModel: DemoModel) {
        dao.saveOrEdit(demoModel = demoModel)
    }

    override fun delete(demoModel: DemoModel) {
        dao.delete(demoModel = demoModel)
    }
}