package com.lahcen.taskmanager.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.lahcen.taskmanager.model.data.Task
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * ViewModel for managing UI-related data in a lifecycle-conscious way.
 *
 * Provides a clean API for the UI layer to interact with the task data.
 * Uses [TaskRepository] to handle data operations and ensures all database
 * interactions run on a background thread via [Dispatchers.IO].
 *
 * @property taskRepository Repository used for performing CRUD operations on [Task].
 */
@HiltViewModel
class TaskViewModel @Inject constructor(
    private val taskRepository: TaskRepository
) : ViewModel() {

    /**
     * A [LiveData] stream of all tasks from the database.
     * Automatically updated when the underlying data changes.
     */
    val allTask: LiveData<List<Task>> = taskRepository.allTasks.asLiveData()

    /**
     * Insert a task into the database.
     * If the task already exists, it will be replaced.
     *
     * @param task The [Task] to insert.
     */
    fun insertTask(task: Task) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                taskRepository.insertTask(task)
            }
        }
    }

    /**
     * Delete a task from the database.
     *
     * @param task The [Task] to delete.
     */
    fun deleteTask(task: Task) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                taskRepository.deleteTask(task)
            }
        }
    }

    /**
     * Update an existing task in the database.
     *
     * @param task The [Task] to update.
     */
    fun updateTask(task: Task) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                taskRepository.updateTask(task)
            }
        }
    }

    /**
     * Search tasks in the database that match the given query.
     * @param search The title of the task.
     */
    fun searchTasks(search: String): LiveData<List<Task>> {
        return taskRepository.searchTasks(search).asLiveData()
    }
}
