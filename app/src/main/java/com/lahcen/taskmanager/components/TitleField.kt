package com.lahcen.taskmanager.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * A composable text input field for entering the **title** (or name) of a task.
 *
 * This component validates whether the entered title is non-empty
 * and updates the [isValid] state accordingly.
 *
 * - If the title is empty, the field is marked as an error.
 * - When valid input is provided, the error state is cleared.
 *
 * The field is styled with rounded corners, a light gray background,
 * and a black focus indicator to match the Task Manager app's design.
 *
 * Example usage:
 * ```
 * val title = remember { mutableStateOf("") }
 * val isValid = remember { mutableStateOf(true) }
 * TitleField(Title = title, isValid = isValid)
 * ```
 *
 * @param Title A [MutableState] of [String] holding the current task title.
 * Updates automatically as the user types.
 *
 * @param isValid A [MutableState] of [Boolean] indicating whether the input
 * is valid. This value becomes `false` when the title is empty.
 */
@Composable
fun TitleField(Title: MutableState<String>, isValid: MutableState<Boolean>) {
    Box(modifier = Modifier.padding(20.dp, 30.dp)) {
        TextField(
            value = Title.value,
            onValueChange = { newTitle ->
                Title.value = newTitle
                isValid.value = newTitle.isNotEmpty()
            },
            isError = isValid.value,
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
}
