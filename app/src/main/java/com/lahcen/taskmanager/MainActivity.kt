package com.lahcen.taskmanager

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.lahcen.BottomNavigationgraph
import com.lahcen.taskmanager.screens.Mainscreen
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

@Composable
fun Bottombar(navController: NavHostController) {
    val items = listOf(
        BottomBarScreen.Home, BottomBarScreen.Calendar, BottomBarScreen.DashBoard
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        items.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen, currentDestination: NavDestination?, navController: NavHostController
) {
    NavigationBarItem(selected = currentDestination?.hierarchy?.any {
        it.route == screen.route
    } == true,
        onClick = { navController.navigate(route = screen.route) },
        label = { Text(text = screen.title) },
        icon = {
            Icon(
                imageVector = screen.icon, contentDescription = null
            )
        })
}







