package com.lahcen.taskmanager.model
import androidx.room.Database
import androidx.room.RoomDatabase
import com.lahcen.taskmanager.model.data.Task
@Database(entities = [Task::class], version = 1, exportSchema = true)
abstract class TaskDataBase : RoomDatabase() {
    abstract fun taskDao(): DAO


}



