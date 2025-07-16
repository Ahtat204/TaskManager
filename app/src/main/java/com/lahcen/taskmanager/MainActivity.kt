package com.lahcen.taskmanager

import Bottombar
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import com.lahcen.taskmanager.ui.theme.TaskManagerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            TaskManagerTheme(darkTheme = true) {
                Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
                    Bottombar(navController)
                }, floatingActionButton ={ FloatingActionButton(onClick = {navController.navigate(route = BottomBarScreen.CreateTask.route)}){
                    Icon(imageVector = Icons.Rounded.Add, contentDescription = null)
                } } , floatingActionButtonPosition = FabPosition.End) { x ->
                    BottomNavigationgraph(navController)


                }

            }
        }
    }

}









