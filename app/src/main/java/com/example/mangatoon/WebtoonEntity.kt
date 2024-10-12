package com.example.mangatoon

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "favorites")
data class WebtoonEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val imageUrl: String,
    val description: String
)
