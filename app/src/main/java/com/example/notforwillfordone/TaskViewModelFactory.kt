package com.example.notforwillfordone.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notforwillfordone.data.TaskDao
import com.example.notforwillfordone.viewmodel.TaskViewModel  // ✅ THIS LINE IS NEEDED

class TaskViewModelFactory(private val dao: TaskDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TaskViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
