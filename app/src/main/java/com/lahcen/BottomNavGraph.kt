package com.lahcen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lahcen.taskmanager.BottomBarScreen
import com.lahcen.taskmanager.screens.Calendar
import com.lahcen.taskmanager.screens.CreateTask
import com.lahcen.taskmanager.screens.DashBoard
import com.lahcen.taskmanager.screens.Mainscreen

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun BottomNavigationgraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route) {
        composable(route = BottomBarScreen.Home.route) {
            Mainscreen(navController)
        }
        composable(route = BottomBarScreen.Calendar.route) {
            Calendar()
        }
        composable(route = BottomBarScreen.DashBoard.route) {
            DashBoard()
        }
        composable(route = BottomBarScreen.CreateTask.route) {
            CreateTask()
        }
    }
}