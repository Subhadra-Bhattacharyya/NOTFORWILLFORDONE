package com.example.notforwillfordone.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.notforwillfordone.data.Task
import com.example.notforwillfordone.data.TaskDao
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TaskViewModel(private val taskDao: TaskDao) : ViewModel() {

    val tasks: StateFlow<List<Task>> = taskDao.getAllTasks()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addTask(title: String, date: String) {
        viewModelScope.launch {
            val task = Task(title = title, date = date)
            taskDao.insertTask(task)
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            taskDao.deleteTask(task)
        }
    }

    fun markTaskDone(task: Task) {
        viewModelScope.launch {
            taskDao.updateTask(task.copy(isDone = true))
        }
    }
}
