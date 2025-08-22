package com.lahcen.taskmanager.model

import com.lahcen.taskmanager.model.data.Task
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Repository module for handling data operations related to [Task].
 *
 * Acts as an abstraction layer between the data source (DAO) and the rest of the app.
 * Provides methods to perform common CRUD (Create, Read, Update, Delete) operations
 * on tasks, as well as utility methods for searching and validating database state.
 *
 * @property taskDAO Data Access Object (DAO) for [Task] entities.
 */
class TaskRepository @Inject constructor(private val taskDAO: DAO)  {

    /**
     * Retrieve all tasks stored in the database.
     *
     * @return A [Flow] emitting the current list of [Task] objects whenever the data changes.
     */
    val allTasks : Flow<List<Task>> = taskDAO.getAllTasks()

    /**
     * Insert a new task into the database.
     * If the task already exists (same primary key), it will be replaced.
     *
     * @param task The [Task] to insert.
     */
    suspend fun insertTask(task: Task) {
        taskDAO.insertTask(task)
    }

    /**
     * Update an existing task in the database.
     *
     * @param task The [Task] to update.
     */
    suspend fun updateTask(task: Task) {
        taskDAO.updateTask(task)
    }

    /**
     * Delete a specific task from the database.
     *
     * @param tasks The [Task] to delete.
     */
    suspend fun deleteTask(tasks: Task) {
        taskDAO.deleteTask(tasks)
    }

    /**
     * Search tasks in the database that match the given query.
     *
     * @param search The query string to match against task fields.
     * @return A [Flow] emitting lists of [Task] objects matching the query.
     */
    fun searchTasks(search: String): Flow<List<Task>> {
        return taskDAO.searchTasks(search)
    }

    /**
     * Check if the database contains any tasks.
     *
     * @return `true` if the database is empty, otherwise `false`.
     */
    suspend fun isDatabaseEmpty(): Boolean {
        return taskDAO.getTaskCount() == 0
    }
}


