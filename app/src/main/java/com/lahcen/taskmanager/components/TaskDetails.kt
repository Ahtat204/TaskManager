package com.lahcen.taskmanager.components

import androidx.compose.foundation.border
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.lahcen.taskmanager.model.data.Task

@Composable
fun TaskDetails(isOpen:Boolean,onDismissRequest: () -> Unit,task: Task){
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Text(
                text = task.title,
                modifier = Modifier.border(width = 1.dp, color = Color.White),
                fontSize = 20.sp,
                color = Color.Black
            )
            Spacer(Modifier.height(40.dp))
            Text(
                textAlign = TextAlign.Center,
                text = task.description.toString(),
                fontSize = 10.sp,
                color = Color.White,
                modifier = Modifier
                    .offset(0.dp, 0.dp)
                    .border(width = 1.dp, color = Color.White)
            )
            Spacer(Modifier.height(40.dp))
            Row {
                Text(
                    text = task.category.toString(),
                    modifier = Modifier
                        .border(width = 1.dp, color = Color.White)
                        .offset(0.dp, 0.dp),
                    fontSize = 29.sp,
                    color = Color.White
                )
                Spacer(Modifier.width(20.dp))
                Text(
                    text = task.dueDate.toString(),
                    modifier = Modifier
                        .border(width = 1.dp, color = Color.White)
                        .offset(0.dp, 0.dp),
                    fontSize = 29.sp,
                    color = Color.Black
                )
                Button(onClick = onDismissRequest) {
                    Text(text = "Close")
                }
            }
        }
    }
}