package com.lahcen.taskmanager.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.lahcen.taskmanager.R
import com.lahcen.taskmanager.ui.theme.opensansExtraBold
import com.lahcen.taskmanager.ui.theme.opensansbold

/**
 * A composable that displays the top portion of the screen with a user greeting, search field,
 * notifications/settings icons, and a section header for tasks.
 *
 * This composable includes:
 * 1. **Profile Image** – displays a user profile picture.
 * 2. **Welcome Text** – greeting the user by name.
 * 3. **Notifications Icon** – a placeholder for notification actions.
 * 4. **Search Field** – an [OutlinedTextField] to search for tasks.
 * 5. **Settings Icon** – a placeholder for settings actions.
 * 6. **Tasks Section Header** – shows "Your Tasks" and a "see all" button.
 *
 * @param Title A [MutableState] containing the current text of the search input.
 * @param modifier Optional [Modifier] for customizing the layout externally.
 *
 * Usage example:
 * ```
 * val searchQuery = remember { mutableStateOf("") }
 * TopScreen(Title = searchQuery)
 * ```
 */
@Composable
fun TopScreen(Title: MutableState<String>, modifier: Modifier = Modifier) {
    // User name (can be replaced by dynamic user data)
    val name: String by remember { mutableStateOf("Lahcen") }

    // Example internal state for tasks (currently unused)
    var task: String by remember { mutableStateOf("") }

    Box(
        modifier
            .clip(RoundedCornerShape(30.dp))
            .background(Color.Black)
            .fillMaxHeight(0.3f)
            .wrapContentHeight(Alignment.Top)
    ) {
        Column {
            // Top Row: Profile image, Welcome text, Notifications icon
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "User Profile",
                    modifier = Modifier
                        .offset(x = 40.dp)
                        .align(Alignment.CenterVertically)
                )

                Text(
                    text = "Welcome \n $name",
                    fontFamily = opensansbold,
                    color = Color.White,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )

                IconButton(
                    modifier = Modifier.padding(10.dp),
                    onClick = { /* TODO: handle notifications click */ }
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Notifications,
                        contentDescription = "Notifications",
                        tint = Color.White
                    )
                }
            }

            // Middle Row: Search field and Settings icon
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedTextField(
                    value = Title.value,
                    onValueChange = { Title.value = it },
                    modifier = Modifier.padding(horizontal = 20.dp),
                    shape = RoundedCornerShape(20.dp),
                    placeholder = { Text("Search for a task", color = Color.White) }
                )

                IconButton(
                    onClick = { /* TODO: handle settings click */ },
                    modifier = Modifier.offset(x = (-10).dp)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Settings,
                        contentDescription = "Settings",
                        tint = Color.White
                    )
                }
            }

            Spacer(Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
            )

            // Bottom Row: "Your Tasks" header and "see all" button
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Your Tasks",
                    color = Color.White,
                    fontFamily = opensansExtraBold,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )

                TextButton(
                    onClick = { /* TODO: handle see all click */ }
                ) {
                    Text(
                        text = "see all",
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.opensansbold))
                    )
                }
            }
        }
    }
}
