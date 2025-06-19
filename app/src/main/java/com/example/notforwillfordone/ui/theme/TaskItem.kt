package com.example.notforwillfordone.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.notforwillfordone.data.Task

@Composable
fun TaskItem(
    task: Task,
    onDoneClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    val backgroundColor = if (task.isDone) Color(0xFFB2FF59) else Color.White

    Card(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .fillMaxWidth()
            .background(backgroundColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text("Title: ${task.title}")
            Text("Date: ${task.date}")
            Row {
                TextButton(onClick = onDoneClick, enabled = !task.isDone) {
                    Text("Done ✅")
                }
                TextButton(onClick = onDeleteClick) {
                    Text("Delete ❌", color = Color.Red)
                }
            }
        }
    }
}
