package com.lahcen.taskmanager.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavHostController
import com.lahcen.taskmanager.BottomBarScreen
import com.lahcen.taskmanager.components.CategoryField
import com.lahcen.taskmanager.components.DescriptionField
import com.lahcen.taskmanager.components.PriorityDialog
import com.lahcen.taskmanager.components.TitleField
import com.lahcen.taskmanager.model.TaskViewModel
import com.lahcen.taskmanager.model.data.Task
import com.lahcen.taskmanager.model.data.priority
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.datetime.time.timepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

/**
 * Composable function for creating a new task.
 *
 * This function displays a form for users to input task details such as title, description,
 * priority, due date, due time, and category. It uses a [TaskViewModel] to handle the
 * insertion of the new task into the underlying data source and a [NavHostController]
 * to navigate away from the screen after the task is successfully created.
 *
 * The UI is built using Jetpack Compose components.
 *
 * @param taskViewModel The ViewModel responsible for handling task-related operations.
 * @param navController The navigation controller used to navigate to other screens.
 */
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CreateTask(taskViewModel:TaskViewModel,navController: NavHostController)  {
    val isValid= remember { mutableStateOf(false) }
    //val taskViewModel:TaskViewModel= viewModel()
    val category= remember { mutableStateOf<String?>("") }
    val expanded = remember { mutableStateOf(false) }
    val taskPriority= remember { mutableStateOf<priority?>(priority.MEDIUM) }
    val dateDialogState = rememberMaterialDialogState()
    val timeDialogState = rememberMaterialDialogState()
    var dueDate by remember { mutableStateOf(LocalDate.now()) }
    var taskTime by remember { mutableStateOf(LocalTime.now()) }
    val description=remember{ mutableStateOf("")}
    val formattedDate = remember {
        derivedStateOf {
            DateTimeFormatter.ofPattern("yyyy-MM-dd").format(dueDate)
        }
    }
    val formattedTime = remember {
        derivedStateOf {
            DateTimeFormatter.ofPattern("hh:mm").format(taskTime)
        }
    }
    val title = remember { mutableStateOf("") }
    val isImportant= remember { mutableStateOf(false) }
    fun insertTask(
        taskname: String,
        taskdescription: String,
        taskpriority: priority,
        Category: String,
        dueDate: LocalDate,
        dueTime: LocalTime
    ){
        if(!isValid.value) return;
      taskViewModel.insertTask(Task(title = taskname, description = taskdescription, priority = taskPriority.value, taskDate=formattedDate.value, dueDate = dueDate.toEpochDay(), category = category.value, isImportant =  isImportant.value))
        navController.navigate(route = BottomBarScreen.Home.route)
    }
    Column {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(80.dp, 0.dp)
        ) {
            Box(
                Modifier
                    .padding(40.dp, 0.dp)
                    .offset(10.dp)
            ) {
                Text(
                    text = "Task Details",
                    fontSize = 30.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
// Save Task Button
            IconButton(
                onClick = {
                    taskPriority.value?.let { category.value?.let { it1 -> insertTask(taskname =title.value , taskdescription =description.value , taskpriority = it, Category = it1, dueDate = dueDate, dueTime = taskTime) } }

                          },
                modifier = Modifier
                    .offset(50.dp, 3.dp)
                    .border(width = 1.dp, color = Color.Cyan, shape = CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Check, contentDescription = null, tint = Color.White
                )
            }
        }
        TitleField(Title=title,isValid=isValid)
        DescriptionField(Description = description,isValid=isValid)
        Checkbox(isImportant.value,onCheckedChange = {isImportant.value=it})
        PriorityDialog(Priority=taskPriority,expanded=expanded)
        Box(modifier = Modifier.padding(20.dp, 20.dp)) {
            Row {
                Button(onClick = { dateDialogState.show() }) {
                    Text(text = formattedDate.value, color = Color.White)
                }


                Button(onClick = { timeDialogState.show() }) {
                    Text(text = formattedTime.value, color = Color.White)
                }
            }
        }
        MaterialDialog(dialogState = dateDialogState,
            properties = DialogProperties(dismissOnClickOutside = true, dismissOnBackPress = true),
            shape = RoundedCornerShape(20.dp),
            autoDismiss = true,
            buttons = {
                positiveButton(text = "Ok")
                negativeButton(text = "Cancel")
            }) {
            datepicker(initialDate = LocalDate.now(),
                title = "Task due date",
                allowedDateValidator = { (it.dayOfYear <= LocalDate.now().dayOfYear) }) {
                dueDate = it
            }
        }

        MaterialDialog(dialogState = timeDialogState,
            properties = DialogProperties(dismissOnClickOutside = true, dismissOnBackPress = true),
            shape = RoundedCornerShape(20.dp),
            autoDismiss = true,
            buttons = {
                positiveButton(text = "Ok")
                negativeButton(text = "Cancel")
            }) {
            timepicker(initialTime = LocalTime.now(),
                title = "Task due date") {
                taskTime= it
            }
        }
        CategoryField(category)
    }
}
