package com.lahcen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lahcen.taskmanager.BottomBarScreen
import com.lahcen.taskmanager.model.TaskViewModel
import com.lahcen.taskmanager.screens.Calendar
import com.lahcen.taskmanager.screens.CreateTask
import com.lahcen.taskmanager.screens.DashBoard
import com.lahcen.taskmanager.screens.Mainscreen
@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun BottomNavigationgraph(navController: NavHostController, taskViewModel: TaskViewModel) {
    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route) {
        composable(route = BottomBarScreen.Home.route) {
            Mainscreen(navController, taskViewModel)
        }
        composable(route = BottomBarScreen.Calendar.route) {
            Calendar()
        }
        composable(route = BottomBarScreen.DashBoard.route) {
            DashBoard()
        }
        composable(route = BottomBarScreen.CreateTask.route) {
            CreateTask(taskViewModel)
        }
    }
}

/**
 * this just for testing
 */
@Preview
@Composable
fun TaskCard() {
    val taskBackground = Color(0xFF000000)

    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(taskBackground)
            .fillMaxWidth()
            .padding(50.dp, 50.dp)
    ) {
        Text(
            textDecoration = TextDecoration.Underline,
            text = "task.title",
            color = Color.White,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(0.dp, (-30).dp)
        )
        IconButton(
            onClick = {}, modifier = Modifier
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
        IconButton(
            onClick = {}, modifier = Modifier.offset((-50).dp, (-60).dp)
        ) {
            Image(
                contentDescription = null,
                imageVector = Icons.Rounded.Delete,
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(Color.White)
            )
        }
        Text(
            "task.description.toString()",
            fontSize = 10.sp,
            color = Color.White,
            modifier = Modifier.align(Alignment.BottomCenter).width(100.dp),maxLines=1, overflow = TextOverflow.Ellipsis
            )

        Text(
            "task.priority.toString()",
            fontSize = 10.sp,
            color = Color.White,
            modifier = Modifier.offset(50.dp,20.dp).align(Alignment.BottomEnd),maxLines=1, overflow = TextOverflow.Ellipsis, softWrap = true, letterSpacing = TextUnit(1f,
                TextUnitType(11)
            )
        )
    }
}

