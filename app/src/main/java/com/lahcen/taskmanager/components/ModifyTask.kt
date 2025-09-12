package com.lahcen.taskmanager.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lahcen.taskmanager.model.data.priority

@Preview(showSystemUi = true)
@Composable
fun ModifyTask() {
//val taskViewModel:TaskViewModel= viewModel()
    val title=remember { mutableStateOf("") }
    val description=remember { mutableStateOf("") }
    val isValid =remember { mutableStateOf(true) }
    val taskCategory=remember{mutableStateOf("")}
    val taskPriority=remember{mutableStateOf(priority.MEDIUM)}
    val isExpanded=remember{mutableStateOf(false)}
val isOpen=remember { mutableStateOf(true) }
    AnimatedVisibility(
        visible = isOpen.value,
        enter = fadeIn(initialAlpha = 0.4f, animationSpec = tween(durationMillis = 250)),
        exit = fadeOut(targetAlpha = 0.4f, animationSpec = tween(durationMillis = 250)),
        modifier = Modifier
    ){

        Column {
            TitleField(title, isValid = isValid)
            DescriptionField(description, isValid = isValid)
            Row(horizontalArrangement = Arrangement.Start) {
                CategoryField(taskCategory)
                Spacer(modifier = Modifier.width(30.dp))
                PriorityDialog(taskPriority, expanded = isExpanded)
            }
        }




    }


}