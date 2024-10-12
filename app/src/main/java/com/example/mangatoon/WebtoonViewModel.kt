package com.example.mangatoon

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WebtoonViewModel(private val dao: WebtoonDao) : ViewModel(){
    private val _favorites = MutableStateFlow<List<WebtoonEntity>>(emptyList())
    val favorites: StateFlow<List<WebtoonEntity>> get() = _favorites

    init{
        getFavorites()
    }

    suspend fun addFavorite(webtoon : WebtoonEntity){
        try{
           val currentFavorites = dao.getFavorites()
            if(!currentFavorites.any{it.id == webtoon.id}){
                viewModelScope.launch {
                    dao.addFavorite(webtoon)
                    _favorites.value = dao.getFavorites()
                }
            }
            else{
                Log.d("WebtoonViewModel", "Webtoon already in favorites: ${webtoon.title}")
            }

        }catch(e: Exception){
            Log.e("WebtoonViewModel", "Error adding favorite : ${e.message}")

        }
    }

    fun getFavorites(){
        viewModelScope.launch {
            _favorites.value = dao.getFavorites()
        }
    }


    fun removeFavorite(webtoon: WebtoonEntity) {
        viewModelScope.launch {
            try {
                dao.removeFavorite(webtoon)  // Remove from database
                getFavorites()  // Update favorites after removing
            } catch (e: Exception) {
                Log.e("WebtoonViewModel", "Error removing favorite: ${e.message}")
            }
        }
    }
}


