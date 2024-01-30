package com.bbeniful.mviandcademo.feature_list.domain.useCase

import com.bbeniful.mviandcademo.core.domain.repositories.DemoRepository
import javax.inject.Inject

class ListDataUseCase @Inject constructor(private val repository: DemoRepository) {

    operator fun invoke() = repository.getAll()
}