package com.lahcen.taskmanager.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lahcen.taskmanager.model.data.Task

/**
 * Composable that displays a card representing a single [Task].
 *
 * @param task The [Task] object to display in the card.
 * @param modify Callback invoked when the user clicks the edit icon to modify the task.
 * @param delete Callback invoked when the user clicks the delete icon to remove the task.
 * Behavior:
 * - Displays task title, description, priority, and category.
 * - Provides clickable icons for modifying and deleting the task.
 * - Highlights the task title and lays out task information in a styled [Box].
 * - On card click, toggles the visibility of the detailed task popup.
 * - Calls [ShowTaskDetails] to show a detailed animated view of the task.
 *
 * Layout:
 * - Uses [Card] and [Box] with rounded corners and a background color.
 * - Task title is centered at the top, with description and priority/category at the bottom.
 * - Icons are aligned to the sides for edit/delete actions.
 */
@Composable
fun TaskCard(
    task: Task,
    modify: () -> Unit,
    delete: () -> Unit
) {
    val taskBackground = Color(0xFF156CD0)
    var popUpScreen: Boolean by remember { mutableStateOf(false) }
    val onVisibilityChange: (Boolean) -> Unit = {popUpScreen=it}
    Card(modifier = Modifier.clickable(onClick = { onVisibilityChange(!popUpScreen) })) {
        Box(contentAlignment = Alignment.TopStart,
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(taskBackground)
                .fillMaxWidth()
                .padding(70.dp, 70.dp)
                .clickable {}) {
            Text(
                textDecoration = TextDecoration.Underline,
                text = task.title,
                color = Color.White,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(0.dp, (-30).dp)
            )
            IconButton(
                onClick = modify,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .offset(49.dp, (-60).dp)
            ) {
                Image(
                    contentDescription = null,
                    imageVector = Icons.Rounded.Create,
                    contentScale = ContentScale.Crop,
                    colorFilter = ColorFilter.tint(Color.White)
                )
            }
            // Delete Icon
            IconButton(
                onClick = delete, modifier = Modifier.offset((-50).dp, (-60).dp)
            ) {
                Image(
                    contentDescription = null,
                    imageVector = Icons.Rounded.Delete,
                    contentScale = ContentScale.Crop,
                    colorFilter = ColorFilter.tint(Color.White)
                )
            }
              // Task Description
            Text(
                task.description.toString(),
                fontSize = 10.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .width(130.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            // Task Priority
            Text(
                text = if (task.priority == null) {
                    ""
                } else {
                    task.priority.toString()
                },
                fontSize = 10.sp,
                color = Color.Green,
                modifier = Modifier
                    .offset(40.dp, 50.dp)
                    .align(Alignment.BottomEnd),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                softWrap = true,
                letterSpacing = TextUnit(
                    1f, TextUnitType(11)
                )
            )

            // Task Category
            Text(
                text = if (task.category == null) {
                    ""
                } else {
                    task.category.toString()
                },
                fontSize = 10.sp,
                color = Color.Green,
                modifier = Modifier
                    .offset((-30).dp, 50.dp)
                    .align(Alignment.BottomStart),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                softWrap = true,
                letterSpacing = TextUnit(
                    1f, TextUnitType(11)
                )
            )
        }
    }
// Show detailed task popup if isVisible is true
  // ShowTaskDetails(isOpen = popUpScreen, task = task,Modifier.offset((-300).dp, (50).dp))
    TaskDetails(isOpen = popUpScreen,onDismissRequest = {onVisibilityChange(!popUpScreen)},task = task)

}