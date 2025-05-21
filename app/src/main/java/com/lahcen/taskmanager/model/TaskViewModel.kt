package com.lahcen.taskmanager.model
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.lahcen.taskmanager.model.data.Task
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(private val taskRepository: TaskRepository):ViewModel() {
    val allTask: LiveData<List<Task>> = taskRepository.allTasks.asLiveData()

    fun inserttask(task: Task) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                taskRepository.inserttask(task)
            }

        }
    }

    fun deletetask(task: List<Task>) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                taskRepository.deletetask(task)
            }
        }
    }



}
