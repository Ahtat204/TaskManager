package com.lahcen.taskmanager

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Custom [Application] class for the Task Manager app.
 *
 * Annotated with [HiltAndroidApp] to trigger Hilt's code generation
 * and enable dependency injection throughout the application.
 */
@HiltAndroidApp
class App : Application()
