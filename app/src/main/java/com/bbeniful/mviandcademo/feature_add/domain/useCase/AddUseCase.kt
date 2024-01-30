package com.bbeniful.mviandcademo.feature_add.domain.useCase

import com.bbeniful.mviandcademo.DemoModel
import com.bbeniful.mviandcademo.core.domain.repositories.DemoRepository
import javax.inject.Inject

class AddUseCase @Inject constructor(private val repository: DemoRepository) {

    operator fun invoke(demoModel: DemoModel) {
        repository.saveOrEdit(demoModel = demoModel)
    }
}