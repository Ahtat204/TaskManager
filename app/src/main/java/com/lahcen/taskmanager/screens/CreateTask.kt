package com.lahcen.taskmanager.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
fun CreateTask()  {
    var Date by remember { mutableStateOf(LocalDate.now()) }
    var Time by remember { mutableStateOf(LocalTime.now()) }
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
                onClick = {},
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
                },
                shape = RoundedCornerShape(25.dp),
                placeholder = { Text(text = "Enter the Task Name or Title") },
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
                value = title,
                onValueChange = { newtitle ->
                    title = newtitle
                },
                shape = RoundedCornerShape(25.dp),
                placeholder = { Text(text = "Enter the Task description") },
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
    }
}