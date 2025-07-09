package com.lahcen.taskmanager.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "tasks")

data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "description")
    val description: String? = null,
    @ColumnInfo(name = "created_date")
    val createdDate: Long = System.currentTimeMillis(),
    val dueDate: Long? = null,
    val isImportant: Boolean = false,
    val isCompleted: Boolean = false,
    val priority: priority? = null, // 0: Low, 1: Medium, 2: High
    val category: String? = null,
    val lastUpdated: Long = System.currentTimeMillis()
    
)
enum class priority{
    LOW,
    MEDIUM,
    HIGH
}


