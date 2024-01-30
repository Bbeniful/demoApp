package com.bbeniful.mviandcademo

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