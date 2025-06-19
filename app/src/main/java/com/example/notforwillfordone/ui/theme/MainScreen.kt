package com.example.notforwillfordone.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.notforwillfordone.viewmodel.TaskViewModel

@Composable
fun MainScreen(viewModel: TaskViewModel) {
    var showDialog by remember { mutableStateOf(false) }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "NOT FOR WILL!!! FOR DONE!!!",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Button(onClick = { showDialog = true }) {
                Text("Add Task")
            }

            Spacer(modifier = Modifier.height(12.dp))

            val tasks by viewModel.tasks.collectAsState()

            LazyColumn {
                items(tasks) { task ->
                    TaskItem(
                        task = task,
                        onDoneClick = { viewModel.markTaskDone(task) },
                        onDeleteClick = { viewModel.deleteTask(task) }
                    )
                }
            }

            if (showDialog) {
                AddTaskDialog(
                    onDismiss = { showDialog = false },
                    onAddTask = { title, date ->
                        viewModel.addTask(title, date)
                        showDialog = false
                    }
                )
            }
        }
    }
}
