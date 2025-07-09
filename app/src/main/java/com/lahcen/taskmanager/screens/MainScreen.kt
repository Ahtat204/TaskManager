package com.lahcen.taskmanager.screens
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lahcen.taskmanager.components.MiddleTopScreen
import com.lahcen.taskmanager.components.TopScreen


@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun Mainscreen(navController: NavController) {

        TopScreen()
        MiddleTopScreen(Modifier.padding(20.dp, 20.dp))


}







