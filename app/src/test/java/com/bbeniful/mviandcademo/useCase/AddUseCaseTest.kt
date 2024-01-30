package com.bbeniful.mviandcademo.useCase

import com.bbeniful.mviandcademo.DemoModel
import com.bbeniful.mviandcademo.repository.FakeRepository
import com.bbeniful.mviandcademo.feature_add.domain.useCase.AddUseCase
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class AddUseCaseTest {

    private val repo = FakeRepository()

    @Test
    fun `test savable`() {
        val useCase = AddUseCase(repo)
        val model = DemoModel(
            name = "Save",
            language = "save language",
            level = "2"
        )
        useCase.invoke(demoModel = model)
        Assert.assertEquals(repo.savableDemoModel?.name, model.name)
        Assert.assertEquals(repo.savableDemoModel?.level, model.level)
        Assert.assertEquals(repo.savableDemoModel?.language, model.language)
    }
}