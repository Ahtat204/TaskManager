package com.lahcen.taskmanager.model

import com.lahcen.taskmanager.model.data.Task
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class TaskViewModelTest {
    private lateinit var viewModel: TaskViewModel
    private lateinit var taskService: TaskService

    @Before
    fun setUp() {
        taskService = Mockito.mock(TaskService::class.java)
        viewModel = TaskViewModel(taskService)
    }

    @Test
    fun getAllTask() {
        val tasks= listOf(Task("title","description"),Task("title","description"))
        Mockito.`when`(taskService.allTasks).thenReturn(null)
        val result=viewModel.allTask
        assertEquals(tasks,result)
    }

    @Test
    fun insertTask() {
    }

    @Test
    fun deleteTask() {
    }

    @Test
    fun updateTask() {
    }

    @Test
    fun searchTasks() {
    }
}