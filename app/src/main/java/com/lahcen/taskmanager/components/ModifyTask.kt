package com.lahcen.taskmanager.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lahcen.taskmanager.model.data.Task


@Composable
fun ModifyTask(isOpen:Boolean, task: Task) {
//val taskViewModel:TaskViewModel= viewModel()

    AnimatedVisibility(
        visible = isOpen,
        enter = fadeIn(initialAlpha = 0.4f, animationSpec = tween(durationMillis = 250)),
        exit = fadeOut(targetAlpha = 0.4f, animationSpec = tween(durationMillis = 250)),
        modifier = Modifier.offset((-300).dp, (50).dp)
    ){}


}