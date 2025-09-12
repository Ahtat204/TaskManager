package com.lahcen.taskmanager.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lahcen.taskmanager.model.data.priority

/**
 * Composable function for displaying a priority selection dialog.it uses [DropdownMenu] with [DropdownMenuItem] to show a list of priority options.
 * @param Priority MutableState representing the selected priority.
 * @param expanded MutableState indicating whether the dropdown menu is expanded.
 */

@Composable
fun PriorityDialog(Priority: MutableState<priority>, expanded: MutableState<Boolean>) {
    Box(Modifier.padding(20.dp, 0.dp)) {
        TextButton(
            onClick = { expanded.value =! expanded.value },
            modifier = Modifier
                .padding(20.dp, 0.dp)
                .border(1.dp, Color.White, RoundedCornerShape(10.dp))
        ) {
            Text(text = Priority.value.toString(), fontSize = 20.sp, color = Color.White)
        }
        DropdownMenu(expanded = expanded.value, onDismissRequest = { expanded.value = false }) {
            DropdownMenuItem(onClick = {
                Priority.value = priority.HIGH
                expanded.value = !expanded.value
            }) {
                Text(text = "MEDIUM")
            }
            DropdownMenuItem(onClick = {
                Priority.value = priority.HIGH
                expanded.value = !expanded.value
            }) {
                Text(text = "HIGH")
            }
            DropdownMenuItem(onClick = {
                Priority.value = priority.LOW
                expanded.value = !expanded.value
            }) {
                Text(text = "LOW")
            }
        }
    }

}