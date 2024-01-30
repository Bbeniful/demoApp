package com.bbeniful.mviandcademo.useCase

import com.bbeniful.mviandcademo.DemoModel
import com.bbeniful.mviandcademo.repository.FakeRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ListDataUseCase {

    private val repo = FakeRepository()

    private val testData = listOf(
        DemoModel(id = 0, name = "1", language = "lan1", level = "1"),
        DemoModel(id = 1, name = "2", language = "lan2", level = "2"),
        DemoModel(id = 2, name = "3", language = "lan3", level = "3")
    )

    @Test
    fun `test the expected list`() = runTest {
        val dataFromRepo = repo.getAll().first()
        Assert.assertEquals(dataFromRepo.size, testData.size)
        Assert.assertEquals(dataFromRepo[0].name, testData[0].name)
        Assert.assertEquals(dataFromRepo[1], testData[1])
        Assert.assertEquals(dataFromRepo[2].language, testData[2].language)
    }
}