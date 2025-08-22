package com.lahcen.taskmanager.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lahcen.taskmanager.model.data.Task

/**
 * Composable that displays detailed information about a [Task] with an animated popup.
 *
 * @param isOpen Controls the visibility of the task details popup.
 * @param task The [Task] object whose details are displayed.
 *
 * Behavior:
 * - The composable uses [AnimatedVisibility] with a fade-in/fade-out animation.
 * - Displays the task's title, description, category, and due date in a styled layout.
 * - Positioned with an offset for screen alignment.
 * - Uses [Column] and [Row] to structure the text elements and spacing.
 * - Each text element has a white border and color for visibility against the background.
 *
 * Example usage:
 * ```
 * var showDetails by remember { mutableStateOf(false) }
 * ShowTaskDetails(isOpen = showDetails, task = myTask)
 * ```
 */
@Composable
fun ShowTaskDetails(isOpen: Boolean, task: Task) {
    AnimatedVisibility(
        visible = isOpen,
        enter = fadeIn(initialAlpha = 0.4f, animationSpec = tween(durationMillis = 250)),
        exit = fadeOut(targetAlpha = 0.4f, animationSpec = tween(durationMillis = 250)),
        modifier = Modifier.offset((-300).dp, (50).dp)
    ) {
        Column(
            modifier = Modifier
                .height(290.dp)
                .width(400.dp)
                .fillMaxWidth(0.7f)
                .fillMaxHeight(0.6f)
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFF156CD0)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = task.title,
                modifier = Modifier.border(width = 1.dp, color = Color.White),
                fontSize = 20.sp,
                color = Color.White
            )
            Spacer(Modifier.height(40.dp))
            Text(
                textAlign = TextAlign.Center,
                text = task.description.toString(),
                fontSize = 10.sp,
                color = Color.White,
                modifier = Modifier
                    .offset(0.dp, 0.dp)
                    .border(width = 1.dp, color = Color.White)
            )
            Spacer(Modifier.height(40.dp))
            Row {
                Text(
                    text = task.category.toString(),
                    modifier = Modifier
                        .border(width = 1.dp, color = Color.White)
                        .offset(0.dp, 0.dp),
                    fontSize = 29.sp,
                    color = Color.White
                )
                Spacer(Modifier.width(20.dp))
                Text(
                    text = task.dueDate.toString(),
                    modifier = Modifier
                        .border(width = 1.dp, color = Color.White)
                        .offset(0.dp, 0.dp),
                    fontSize = 29.sp,
                    color = Color.White
                )
            }
        }
    }
}
