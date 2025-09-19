package com.lahcen.taskmanager.model

import com.lahcen.taskmanager.model.data.Task
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class TaskServiceTest {
    private lateinit var dao: DAO
    private lateinit var taskService: TaskService

    @Before
    fun setUp() {
        dao = Mockito.mock(DAO::class.java)
        taskService = TaskService(dao)
    }

    @Test
    fun getAllTasks() = runBlocking {
        val taskList = listOf(Task("title", "description", 1))
        val tasks = flowOf(taskList)
        Mockito.`when`(dao.getAllTasks()).thenReturn(tasks)
        val result = taskService.allTasks.toList()
        assertEquals(taskList, result)
    }

    @Test
    fun insertTask() {
        runBlocking {
            val task = Task("title", "description")
            Mockito.`when`(dao.insertTask(task)).thenReturn(Unit)
            val result = taskService.insertTask(task)
            assertTrue(result)
        }
    }

    @Test
    fun updateTask() = runBlocking {
        val task = Task("hi", "there", 1)
        Mockito.`when`(dao.updateTask(task)).thenReturn(Unit)
        val result = taskService.updateTask(task)
        assertTrue(result)
    }

    @Test
    fun deleteTask() = runBlocking {
        val task = Task("hi", "there", 1)
        Mockito.`when`(dao.deleteTask(task)).thenReturn(Unit)
        val result = taskService.deleteTask(task)
        assertTrue(result)
    }

    @Test
    fun searchTasks() = runBlocking {
        val task = listOf(Task("hi", "there", 444))
        val flowlist = flowOf(task) // Flow<List<Task>>
        Mockito.`when`(dao.searchTasks(task[0].title)).thenReturn(flowlist)

        val result = taskService.searchTasks(task[0].title).toList() // List<List<Task>>
        assertEquals(task[0], result[0][0])
    }

    @Test
    fun isDatabaseEmpty() {
    }
}