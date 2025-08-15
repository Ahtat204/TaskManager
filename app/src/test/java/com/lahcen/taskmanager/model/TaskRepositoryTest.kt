package com.lahcen.taskmanager.model


import com.lahcen.taskmanager.model.data.Task
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockedConstruction.Context
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class TaskRepositoryTest {
   private lateinit var repository: TaskRepository
    @Mock
    private lateinit var  dao: DAO

    @Before
    fun setUp() {

        repository = TaskRepository(dao)
    }

    @After
    fun tearDown() {
        // Clean up any resources if needed

    }

    @Test
    fun getAllTasks() {
    }

    @Test
    fun inserttask() = runBlocking {
        val task = Task("title", "desc", 1)
        repository.inserttask(task)
        verify(dao).insertTask(task)

    }

    @Test
    fun updatetask() {
    }

    @Test
    fun deletetask()= runBlocking {
        val task = Task("title", "desc", 1)
        repository.deletetask(task)
        verify(dao).deleteTask(task)
    }

    @Test
    fun searchTasks() {
    }

    @Test
    fun isDatabaseEmpty() {

    }
}