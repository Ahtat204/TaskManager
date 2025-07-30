import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.lahcen.taskmanager.BottomBarScreen

@Composable
fun Bottombar(navController: NavHostController) {
    val items = listOf(
        BottomBarScreen.Home, BottomBarScreen.Calendar, BottomBarScreen.DashBoard
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(backgroundColor = Color.Black) {
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