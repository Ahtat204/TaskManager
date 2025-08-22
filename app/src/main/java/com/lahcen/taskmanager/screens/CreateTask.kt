package com.lahcen.taskmanager.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.compose.rememberNavController
import com.lahcen.taskmanager.BottomBarScreen
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

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CreateTask(taskViewModel:TaskViewModel)  {
    val navController = rememberNavController()
    var isValid:Boolean by remember { mutableStateOf(false) }
    //val taskViewModel:TaskViewModel= viewModel()
    var category: String by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var Priority: priority by remember { mutableStateOf(priority.MEDIUM) }
    val dateDialogState = rememberMaterialDialogState()
    val timeDialogState = rememberMaterialDialogState()
    var Date by remember { mutableStateOf(LocalDate.now()) }
    var Time by remember { mutableStateOf(LocalTime.now()) }
    var description:String by remember{ mutableStateOf("")}
    val foramattedDate = remember {
        derivedStateOf {
            DateTimeFormatter.ofPattern("yyyy-MM-dd").format(Date)
        }
    }
    val foramattedTime = remember {
        derivedStateOf {
            DateTimeFormatter.ofPattern("hh:mm").format(Time)
        }
    }
    var title: String by remember { mutableStateOf("") }
    fun insertTask(taskname:String,taskdescription:String,taskpriority:priority,Category:String,dueDate:LocalDate,dueTime:LocalTime){
        taskViewModel.insertTask(Task(title = taskname, description = taskdescription, priority = Priority))
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

            IconButton(
                onClick = {
                    insertTask(taskname =title , taskdescription =description , taskpriority = Priority, Category = category, dueDate = Date, dueTime = Time)

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
        Box(modifier = Modifier.padding(20.dp, 30.dp)) {
            TextField(
                value = title,
                onValueChange = { newtitle ->
                    title = newtitle
                    isValid=newtitle.isNotEmpty()
                },
               isError = !isValid,
                shape = RoundedCornerShape(25.dp),
                label = { Text(text = "Enter the Task Name or Title") },
                modifier = Modifier
                    .border(
                        width = 1.dp, color = Color.Transparent, shape = RoundedCornerShape(20.dp)
                    )
                    .fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    backgroundColor = Color.LightGray,
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.Black
                )
            )
        }
        Box(modifier = Modifier.padding(20.dp, 30.dp)) {
            TextField(
                value = description,
                onValueChange = { newdesc ->
                    description= newdesc
                   isValid= newdesc.isNotEmpty()
                },

                shape = RoundedCornerShape(25.dp),
                label = {Text(text = "Enter the Task description")  },
                modifier = Modifier
                    .border(
                        width = 1.dp, color = Color.Transparent, shape = RoundedCornerShape(20.dp)
                    )
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    backgroundColor = Color.LightGray,
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.Black
                )
            )
        }

        Box() {
            TextButton(
                onClick = { expanded = !expanded },
                modifier = Modifier
                    .padding(20.dp, 0.dp)
                    .border(1.dp, Color.White, RoundedCornerShape(10.dp))
            ) {
                Text(text = Priority.toString(), fontSize = 20.sp, color = Color.White)
            }
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                DropdownMenuItem(onClick = {
                    Priority = priority.MEDIUM
                    expanded =! expanded
                }) {
                    Text(text = "MEDIUM")
                }
                DropdownMenuItem(onClick = {
                    Priority = priority.HIGH
                    expanded =! expanded
                }) {
                    Text(text = "HIGH")
                }
                DropdownMenuItem(onClick = {
                    Priority = priority.LOW
                    expanded =!expanded}) {

                    Text(text = "LOW")
                }
            }
    }
        Box(modifier = Modifier.padding(20.dp, 20.dp)) {
            Row {
                Button(onClick = { dateDialogState.show() }) {
                    Text(text = foramattedDate.value, color = Color.White)
                }


                Button(onClick = { timeDialogState.show() }) {
                    Text(text = foramattedTime.value, color = Color.White)
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
                Date = it
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
                Time= it
            }
        }
        Box(
            modifier = Modifier
                .wrapContentWidth()
                .background(Color.Transparent)
                .offset(0.dp, 0.dp)
                .align(Alignment.End)
                .offset((-5).dp, (-80).dp)
                .clip(
                    RoundedCornerShape(25.dp)
                )
        ) {
            TextField(value = category,
                onValueChange = { category = it },
                placeholder = { Text("Category") },
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .border(
                        width = 1.dp, color = Color.Transparent
                    )
                    .background(Color.White)
                    .fillMaxWidth(0.25f)
            )
        }
    }
}
