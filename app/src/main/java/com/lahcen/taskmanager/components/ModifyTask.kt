package com.lahcen.taskmanager.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.lahcen.taskmanager.model.data.Task


/**
 * A composable function that displays a dialog for modifying an existing task.
 *
 * This dialog allows users to edit the title, description, category, and priority of a task.
 *
 * @param notOpened A boolean flag indicating whether the dialog should be initially closed.
 *                  If `true`, the dialog will not be shown. If `false`, the dialog will be displayed.
 * @param onDismissRequest A lambda function that will be invoked when the user requests to dismiss the dialog
 *                         (e.g., by clicking outside the dialog or pressing the back button).
 * @param task The [Task] object containing the initial data to be displayed and modified in the dialog.
 * @param modify A lambda function that will be invoked when the user confirms the modifications to the task.
 *               This is typically triggered by a "save" or "check" button within the dialog.
 */
@Composable
fun ModifyTask(notOpened: Boolean, onDismissRequest: () -> Unit, task: Task, modify: () -> Unit) {
    val title = remember { mutableStateOf(task.title) }
    val description = remember { mutableStateOf(task.description.toString()) }
    val isValid = remember { mutableStateOf(true) }
    val taskCategory = remember { mutableStateOf(task.category) }
    val taskPriority = remember { mutableStateOf(task.priority) }
    val isExpanded = remember { mutableStateOf(false) }
    if (!notOpened) return
    Dialog(onDismissRequest = onDismissRequest) {
        Column {
            IconButton(onClick = modify, modifier = Modifier.background(Color.Blue).offset(30.dp,30.dp)) {
                Icon(
                    imageVector = Icons.Rounded.Check,
                    contentDescription = null,
                    modifier = Modifier.size(10.dp)
                )
            }
            TitleField(title, isValid = isValid)
            DescriptionField(description, isValid = isValid)
            Row(horizontalArrangement = Arrangement.Start) {
                CategoryField(taskCategory)
                Spacer(modifier = Modifier.width(50.dp))
                PriorityDialog(taskPriority, expanded = isExpanded)

            }
        }
    }
}

