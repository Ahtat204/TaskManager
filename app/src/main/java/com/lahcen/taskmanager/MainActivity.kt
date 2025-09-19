package com.lahcen.taskmanager

import BottomBar
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.lahcen.BottomNavigationgraph
import com.lahcen.taskmanager.model.TaskViewModel
import com.lahcen.taskmanager.ui.theme.TaskManagerTheme
import dagger.hilt.android.AndroidEntryPoint
/**
 * Main entry point of the Task Manager application.
 *
 * This activity initializes the app's UI using Jetpack Compose,
 * sets up navigation with a [NavController], and provides a
 * [TaskViewModel] instance for managing task-related state.
 *
 * Responsibilities:
 * - Applies the [TaskManagerTheme].
 * - Hosts the app's [Scaffold] with:
 *   - A bottom navigation bar ([BottomBar]).
 *   - A floating action button (FAB) for navigating to the
 *     task creation screen.
 * - Delegates navigation logic to [BottomNavigationgraph].
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val myViewModel: TaskViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            TaskManagerTheme(darkTheme = true) {
                Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
                    BottomBar(navController)
                }, floatingActionButton = {
                    FloatingActionButton(onClick = { navController.navigate(route = BottomBarScreen.CreateTask.route) }) {
                        Icon(imageVector = Icons.Rounded.Add, contentDescription = null)
                    }
                }, floatingActionButtonPosition = FabPosition.End) { x ->
                    BottomNavigationgraph(navController, taskViewModel = myViewModel)
                }
            }
        }
    }

}









