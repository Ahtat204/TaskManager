package com.lahcen.taskmanager.model

import com.lahcen.taskmanager.model.data.Task
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskRepository @Inject constructor(private val taskDAO: DAO)  {
val allTasks : Flow<List<Task>> = taskDAO.getAllTasks()
    suspend fun inserttask(task: Task) {
        taskDAO.insertTask(task)
    }

    suspend fun updatetask(task: Task) {
        taskDAO.updateTask(task)
    }
    suspend fun deletetask(tasks: List<Task>) {
        taskDAO.deleteTask(tasks)
    }
    fun searchTasks(search: String): Flow<List<Task>> {
        return taskDAO.searchTasks(search)}
suspend fun isDatabaseEmpty(): Boolean {
    return taskDAO.getTaskCount()==0
}



}


