package com.lahcen.taskmanager.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lahcen.taskmanager.model.TaskViewModel
import com.lahcen.taskmanager.model.data.Task
import kotlin.math.abs

/**
 * Composable that displays a horizontally scrollable list of task cards
 * at the top-middle portion of the screen.
 *
 * Observes the list of tasks from [TaskViewModel] and renders each task
 * using [TaskCard]. Supports updating and deleting tasks, and allows
 * a pop-up UI state to be toggled per card.
 *
 * @param modifier Optional [Modifier] for customizing layout or appearance.
 * @param taskViewModel The [TaskViewModel] used to fetch, update, and delete tasks.
 *
 * Behavior:
 * - Uses a [LazyRow] to display tasks horizontally.
 * - Each task card supports update and delete operations via callbacks.
 * - A pop-up screen visibility state is maintained locally for UI interactions.
 * - Tasks are observed as [LiveData] and automatically updated when the data changes.
 */
@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun MiddleTopScreen(
    modifier: Modifier = Modifier,
    taskViewModel: TaskViewModel
) {
    var popUpScreen: Boolean by remember { mutableStateOf(false) }
    val taskList by taskViewModel.allTask.observeAsState(listOf(Task("", "task2")))

    Column(
        modifier = Modifier
            .offset(20.dp, 45.dp)
            .padding(0.dp, 60.dp)
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 97.dp),
        ) {
            items(abs(taskList.size)) { item ->
                TaskCard(
                    task = taskList[item],
                    modify = { taskViewModel.updateTask(taskList[item]) },
                    delete = { taskViewModel.deleteTask(taskList[item]) },
                    isVisible = popUpScreen,
                    onVisibilityChange = { popUpScreen = it }
                )
            }
        }
    }
}
