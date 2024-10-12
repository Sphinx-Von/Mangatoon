package com.example.mangatoon

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WebtoonDao{

    @Insert
    suspend fun addFavorite(webtoon: WebtoonEntity)

    @Query("SELECT * FROM favorites")
    suspend fun getFavorites(): List<WebtoonEntity>

    @Delete
    suspend fun removeFavorite(webtoon: WebtoonEntity)
}