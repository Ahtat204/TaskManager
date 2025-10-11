package com.lahcen.taskmanager.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lahcen.taskmanager.components.TaskCard
import com.lahcen.taskmanager.model.TaskViewModel
import com.lahcen.taskmanager.model.data.Task
import com.lahcen.taskmanager.model.data.priority
import io.github.boguszpawlowski.composecalendar.kotlinxDateTime.now
import kotlinx.datetime.LocalDate

@Composable
fun DashBoard(taskViewModel: TaskViewModel,tasks:List<Task>) {
    Column {
        Text(text = "Important Task", fontSize = 30.sp)
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(1.dp, 90.dp),
        ) {
            items(tasks.apply {
                this.filter { it.priority == priority.HIGH }
            }.size) { item ->
                TaskCard(task = tasks[item],
                    modify = { taskViewModel.updateTask(tasks[item]) },
                    delete = { taskViewModel.deleteTask(tasks[item]) })
            }
        }

        Text(text = "Today's Tasks", fontSize = 30.sp)
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(1.dp, 90.dp),
        ) {
            items(tasks.apply {
                this.filter { it.taskDate == LocalDate.now().toString() }
            }.size) { item ->
                TaskCard(task = tasks[item],
                    modify = { taskViewModel.updateTask(tasks[item]) },
                    delete = { taskViewModel.deleteTask(tasks[item]) })
            }
        }
        Text(text = "Completed tasks", fontSize = 30.sp)
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(1.dp, 90.dp),
        ) {
            items(tasks.apply {
                this.filter { it.isCompleted }
            }.size) { item ->
                TaskCard(task = tasks[item],
                    modify = { taskViewModel.updateTask(tasks[item]) },
                    delete = { taskViewModel.deleteTask(tasks[item]) })
            }
        }
    }
}