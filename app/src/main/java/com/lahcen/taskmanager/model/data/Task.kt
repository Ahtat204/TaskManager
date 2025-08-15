package com.lahcen.taskmanager.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "tasks")
data class Task(
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "description")
    var description: String? = null,
    @ColumnInfo(name = "created_date")
    var createdDate: Long = System.currentTimeMillis(),
    var dueDate: Long? = null,
    var isImportant: Boolean = false,
    var isCompleted: Boolean = false,
    var priority: priority?=null, // 0: Low, 1: Medium, 2: High
    var category: String? = null,
    val lastUpdated: Long = System.currentTimeMillis(),
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)
enum class priority{
    LOW,
    MEDIUM,
    HIGH
}


