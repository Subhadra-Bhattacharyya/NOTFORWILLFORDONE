package com.example.notforwillfordone.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val isDone: Boolean = false,
    val date: String // e.g., "2025-06-13"
)

