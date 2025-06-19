package com.example.notforwillfordone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.notforwillfordone.data.TaskDatabase
import com.example.notforwillfordone.ui.MainScreen
import com.example.notforwillfordone.ui.theme.NOTFORWILLFORDONETheme
import com.example.notforwillfordone.viewmodel.TaskViewModel
import com.example.notforwillfordone.viewmodel.TaskViewModelFactory

class MainActivity : ComponentActivity() {

    private val viewModel: TaskViewModel by viewModels {
        TaskViewModelFactory(TaskDatabase.getDatabase(this).taskDao())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NOTFORWILLFORDONETheme {
                MainScreen(viewModel = viewModel)
            }
        }
    }
}
