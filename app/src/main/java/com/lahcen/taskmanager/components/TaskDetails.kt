package com.lahcen.taskmanager.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.lahcen.taskmanager.model.data.Task

/**
 *  Composable function for showing a task details dialog.it uses the [Dialog] composable
 * @param isOpen Boolean indicating whether the dialog should be open.
 * @param onDismissRequest Callback to be invoked when the dialog is dismissed.
 * @param task The task to display details for.
 * Behavior:
 * When User click on a Task in the List of Tasks , this function is called to show the details of the task.
 * and with clicking the [Button],or Anywhere outside the Dialog, it Closes the dialog is closed.
 *
 */
@Composable
fun TaskDetails(isOpen: Boolean, onDismissRequest: () -> Unit, task: Task) {
    if (!isOpen) return

    Dialog(onDismissRequest = onDismissRequest) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = task.title, fontSize = 20.sp, color = Color.Black
                )
                Spacer(Modifier.height(20.dp))
                Text(
                    text = task.description ?: "",
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Spacer(Modifier.height(20.dp))
                Row {
                    Text(
                        text = task.category ?: "", fontSize = 16.sp, color = Color.DarkGray
                    )
                    Spacer(Modifier.width(20.dp))
                    Text(
                        text = task.taskDate ?: "", fontSize = 16.sp, color = Color.Black
                    )
                    Spacer(Modifier.height(40.dp))
                    Button(
                        onClick = onDismissRequest,
                        modifier = Modifier.offset(0.dp, 100.dp),
                        shape = RoundedCornerShape(15.dp)
                    ) {
                        Text(text = "Close")
                    }
                }
            }
        }
    }
}
