package com.lahcen.taskmanager

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lahcen.taskmanager.model.TaskViewModel
import com.lahcen.taskmanager.screens.Mainscreen
import com.lahcen.taskmanager.ui.theme.TaskManagerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val myViewModel: TaskViewModel by viewModels()
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.apply {
            statusBarColor = Color.BLACK
        }

        setContent {
            TaskManagerTheme {
                Mainscreen(myViewModel)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.R)
    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    private fun HomescreenPreview() {

        Mainscreen(myViewModel)
    }
}






