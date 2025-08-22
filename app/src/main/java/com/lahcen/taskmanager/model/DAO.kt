package com.lahcen.taskmanager.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.lahcen.taskmanager.model.data.Task
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) for managing [Task] entities in the Room database.
 *
 * Defines all CRUD operations and queries used to interact with the `tasks` table.
 */
@Dao
interface DAO {

    /**
     * Insert a new [Task] into the database.
     * If a task with the same primary key already exists, it will be replaced.
     *
     * @param task The [Task] to insert.
     */
    @Insert
    suspend fun insertTask(task: Task)

    /**
     * Update an existing [Task] in the database.
     *
     * @param task The [Task] to update.
     */
    @Update
    suspend fun updateTask(task: Task)

    /**
     * Delete a specific [Task] from the database.
     *
     * @param task The [Task] to delete.
     */
    @Delete
    suspend fun deleteTask(task: Task)

    /**
     * Retrieve all tasks stored in the database.
     *
     * @return A [Flow] emitting the list of all [Task] objects whenever data changes.
     */
    @Query("SELECT * FROM tasks")
    fun getAllTasks(): Flow<List<Task>>

    /**
     * Search for tasks whose title matches the given query.
     * Uses SQL `LIKE`, so wildcards (`%`) can be included in the [search] string.
     *
     * Example: `"%home%"` finds all tasks with "home" in the title.
     *
     * @param search The search query string.
     * @return A [Flow] emitting the list of matching [Task] objects.
     */
    @Query("SELECT * FROM tasks WHERE title LIKE :search")
    fun searchTasks(search: String): Flow<List<Task>>

    /**
     * Get the total number of tasks stored in the database.
     *
     * @return The number of tasks as an [Int].
     */
    @Query("SELECT COUNT(*) FROM tasks")
    suspend fun getTaskCount(): Int
}
