package com.lahcen.taskmanager.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * A composable input field used for entering or editing the **category** of a task.
 *
 * This component is part of the Task Manager app and is styled with rounded
 * corners, a white background, and subtle positioning offsets to match the
 * design language of the application.
 *
 * The text entered into the field is stored in the provided [MutableState].
 *
 * Example usage:
 * ```
 * val category = remember { mutableStateOf("") }
 * CategoryField(category = category)
 * ```
 *
 * @param category A [MutableState] of [String] that holds the current category value.
 * The state is automatically updated as the user types.
 */
@Composable
fun CategoryField(category: MutableState<String>,modifier: Modifier=Modifier) {
  //  Text(text = "Specify the Category of your task", fontSize = 20.sp, color = Color.White)
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .background(Color.Transparent)
            .offset(0.dp, 0.dp)
            .offset((100).dp, (0).dp)
            .clip(
                RoundedCornerShape(25.dp)
            )
    ) {

        TextField(
            value = category.value,
            onValueChange = { category.value = it },
            placeholder = { Text("Category") },
            shape = RoundedCornerShape(25.dp),
            modifier = Modifier
                .border(
                    width = 1.dp, color = Color.Transparent
                ).clip(RoundedCornerShape(25.dp))
                .background(Color.White)
                .fillMaxWidth(0.45f)
        )
    }
}
