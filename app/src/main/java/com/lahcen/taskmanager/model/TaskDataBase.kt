package com.lahcen.taskmanager.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lahcen.taskmanager.model.data.Task

/**
 * Room database for the Task Manager app.
 *
 * Defines the database configuration and serves as the main access point
 * to the persisted task data. Provides an abstract method to retrieve
 * the [DAO] for performing CRUD operations on [Task] entities.
 *
 * @property entities List of entity classes included in the database. In this case, [Task].
 * @property version Version number of the database. Increment this when making schema changes.
 * @property exportSchema Whether to export the database schema into a folder. Set to true for version tracking.
 */
@Database(entities = [Task::class], version = 1, exportSchema = true)
abstract class TaskDataBase : RoomDatabase() {

    /**
     * Provides the Data Access Object (DAO) for [Task].
     *
     * Use this DAO to perform insert, update, delete, and query operations
     * on the `tasks` table.
     *
     * @return An instance of [DAO].
     */
    abstract fun taskDao(): DAO
}
