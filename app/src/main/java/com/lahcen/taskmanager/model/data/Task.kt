package com.lahcen.taskmanager.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents a task in the Task Manager application.
 *
 * This entity is stored in the local Room database under the `tasks` table.
 * Each task includes metadata such as title, description, creation date,
 * due date, importance, completion status, priority, and category.
 *
 * @property title The main title or name of the task.
 * @property description Optional detailed explanation of the task.
 * @property createdDate The timestamp (in milliseconds) when the task was created.
 * @property dueDate Optional deadline (in milliseconds) for the task.
 * @property isImportant Indicates whether the task is flagged as important.
 * @property isCompleted Indicates whether the task is marked as completed.
 * @property priority The priority level of the task (Low, Medium, or High).
 * @property category Optional category name to group related tasks.
 * @property lastUpdated Timestamp (in milliseconds) when the task was last modified.
 * @property id Auto-generated primary key for uniquely identifying each task.
 */
@Entity(tableName = "tasks")
data class Task(
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "description")
    var description: String? = null,
    @ColumnInfo(name = "created_date")
    var createdDate: Long = System.currentTimeMillis(),
    var taskDate:String?=null,
    var dueDate: Long? = null,
    var isImportant: Boolean = false,
    var isCompleted: Boolean = false,
    @ColumnInfo(name = "priority")
    /**
     * Priority level of the task:
     * - LOW: Least urgent
     * - MEDIUM: Moderately urgent
     * - HIGH: Most urgent
     */
    var priority: priority? = null,
    var category: String? = null,
    val lastUpdated: Long = System.currentTimeMillis(),
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)

/**
 * Enumeration representing the priority levels of a task.
 */
enum class priority {
    /** Low urgency task. */
    LOW,

    /** Medium urgency task. */
    MEDIUM,

    /** High urgency task. */
    HIGH
}
