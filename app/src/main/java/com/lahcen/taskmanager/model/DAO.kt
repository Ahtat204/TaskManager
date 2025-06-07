package com.lahcen.taskmanager.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.lahcen.taskmanager.model.data.Task
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow


@Dao
interface DAO {
    @Insert(Task::class)
    suspend fun insertTask(task: Task)
    @Update(Task::class)
    suspend fun updateTask(task: Task)
    @Delete(Task::class)
    suspend fun deleteTask(task: Task)
    @Query("SELECT * FROM tasks")
     fun getAllTasks(): Flow<List<Task>>
    // Search with LIKE
    @Query("SELECT * FROM tasks WHERE title LIKE :search")
    fun searchTasks(search: String): Flow<List<Task>>
    @Query("SELECT COUNT(*) FROM tasks")
    suspend fun getTaskCount(): Int

}