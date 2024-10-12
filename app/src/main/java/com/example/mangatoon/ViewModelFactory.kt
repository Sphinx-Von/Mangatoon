
package com.example.mangatoon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class WebtoonViewModelFactory(private val dao: WebtoonDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WebtoonViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WebtoonViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
