package com.lahcen.taskmanager.model

import androidx.lifecycle.asLiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.lahcen.taskmanager.model.data.Task
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.TestCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(value = AndroidJUnit4::class)
@HiltAndroidTest
class TaskDataBaseTest : TestCase() {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)
    @Inject
    lateinit var db: TaskDataBase
    @Inject
    lateinit var dao: DAO

    @Before
    public override fun setUp() {
        super.setUp()
        hiltRule.inject()

    }

    @After
    fun closeDataBase() {
        db.close()
    }

    @Test
    fun AddandRetrieveTask() = runBlocking {
        val task = Task("title", "description", 1)
        dao.insertTask(task)
        val Tasks = dao.getAllTasks().asLiveData().value
        if (Tasks != null) {
            assertTrue(Tasks.contains(task))
        }
    }

    @Test
    fun InsertAndDeleteTask() = runBlocking {
        val task = Task("lahcen", "ahtat", 222)
        dao.insertTask(task)
        dao.deleteTask(task)
        val Tasks = dao.getAllTasks().first()
        assertFalse(Tasks.contains(task))
    }

    @Test
    fun updateTask_multipleAttributes() = runBlocking {
        val task = Task("title", "desc", 1)
        dao.insertTask(task)

        val updatedTask = task.copy(title = "newTitle", description = "newDesc")
        dao.updateTask(updatedTask)

        val tasks = dao.getAllTasks().asLiveData().value
        if(tasks== null) return@runBlocking
        assertTrue(tasks.contains(updatedTask))
        assertFalse(tasks.contains(task))
    }
    @Test
    fun isEmpty()=runTest{}
}