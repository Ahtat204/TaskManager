package com.lahcen.taskmanager.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
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
 * A composable text input field for entering the **description** of a task.
 *
 * Unlike [TitleField], this field allows multi-line input by expanding
 * to occupy up to half of the available height, making it suitable for
 * longer text such as notes or task details.
 *
 * The [isValid] state is updated dynamically:
 * - `true` if the description is not empty
 * - `false` if the field is empty
 *
 * Styled with rounded corners, light gray background, and a black
 * focus indicator to align with the Task Manager app’s design system.
 *
 * Example usage:
 * ```
 * val description = remember { mutableStateOf("") }
 * val isValid = remember { mutableStateOf(true) }
 * DescriptionField(Description = description, isValid = isValid)
 * ```
 *
 * @param Description A [MutableState] of [String] holding the current task description.
 * Updates automatically as the user types.
 *
 * @param isValid A [MutableState] of [Boolean] indicating whether the input
 * is valid. Becomes `false` if the description is empty.
 */
@Composable
fun DescriptionField(Description: MutableState<String>, isValid: MutableState<Boolean>) {
    Box(modifier = Modifier.padding(20.dp, 30.dp)) {
        TextField(
            value = Description.value,
            onValueChange = { NewDesc ->
                Description.value = NewDesc
                isValid.value = NewDesc.isNotEmpty()
            },
            isError = isValid.value,
            shape = RoundedCornerShape(25.dp),
            label = { Text(text = "Enter the Task Description") },
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
