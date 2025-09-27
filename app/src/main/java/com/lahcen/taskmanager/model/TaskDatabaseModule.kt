package com.lahcen.taskmanager.model

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

/**
 * Hilt module that provides dependencies related to the Room database.
 *
 * This module is installed in the [SingletonComponent], meaning
 * its dependencies live as long as the application does.
 */
@Module
@InstallIn(SingletonComponent::class)
internal class TaskDatabaseModule {

    /**
     * Singleton instance of [TaskDataBase].
     * Declared as [Volatile] to ensure visibility of changes across threads.
     */
    @Volatile
    private var taskDatabaseInstance: TaskDataBase? = null

    /**
     * Provides a singleton instance of [TaskDataBase].
     *
     * @param context The application context injected by Hilt.
     * @return A singleton instance of the Room database.
     */
    @Provides
    @Singleton
    fun getDatabase(@ApplicationContext context: Context): TaskDataBase {
        return taskDatabaseInstance ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                            context.applicationContext,
                            TaskDataBase::class.java,
                            "task_db"
                        ).fallbackToDestructiveMigration(true).build()
            taskDatabaseInstance = instance
            instance
        }
    }

    /**
     * Provides the DAO for accessing [Task] data from [TaskDataBase].
     *
     * @param taskDataBase The database instance.
     * @return The DAO for tasks.
     */
    @Provides
    fun provideTaskDao(taskDataBase: TaskDataBase) = taskDataBase.taskDao()

    /**
     * Test-only module that provides an in-memory Room database.
     *
     * This allows running tests without persisting data to disk.
     */
    @Module
    @InstallIn(SingletonComponent::class)
    object TestAppModule {
        /**
         * Provides an in-memory instance of [TaskDataBase] for testing purposes.
         *
         * @param context The application context.
         * @return An in-memory database instance with main-thread queries allowed.
         */
        @Provides
        @Named("task_db")
        fun provideInMemoryDb(@ApplicationContext context: Context) =
            Room.inMemoryDatabaseBuilder(
                context,
                TaskDataBase::class.java
            )
                .allowMainThreadQueries()
                .build()
    }
}
