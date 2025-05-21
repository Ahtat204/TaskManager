package com.lahcen.taskmanager.model

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class TaskDatabaseModule {
        @Volatile
        var INSTANCE: TaskDataBase? = null
    @Provides
        @Singleton
        fun getDatabase(@ApplicationContext context: Context): TaskDataBase{
            return INSTANCE?: synchronized(this){
                val instance= Room.databaseBuilder(context.applicationContext,TaskDataBase::class.java,"task_db").build()
                INSTANCE=instance
                instance


        }


    }
    @Provides
    fun provideTaskDao(taskDataBase: TaskDataBase)=taskDataBase.taskDao()
}