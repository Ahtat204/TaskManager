package com.lahcen.taskmanager.model


import com.lahcen.taskmanager.model.data.Task
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
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
    fun insertTask() = runBlocking {
        val task = Task("title", "desc", 1)
        repository.insertTask(task)
        verify(dao).insertTask(task)

    }

    @Test
    fun updateTask() {
    }

    @Test
    fun deleteTask()= runBlocking {
        val task = Task("title", "desc", 1)
        repository.deleteTask(task)
        verify(dao).deleteTask(task)
    }

    @Test
    fun searchTasks() {
    }

    @Test
    fun isDatabaseEmpty() {

    }
}