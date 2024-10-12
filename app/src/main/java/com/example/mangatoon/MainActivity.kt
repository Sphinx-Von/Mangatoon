package com.example.mangatoon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider

import com.example.mangatoon.ui.theme.MangatoonTheme


class MainActivity : ComponentActivity() {
    private lateinit var dao: WebtoonDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = AppDatabase.getDatabase(this)
        dao = database.webtoonDao()

        val viewModel: WebtoonViewModel = ViewModelProvider(
            this, WebtoonViewModelFactory(dao)
        ).get(WebtoonViewModel::class.java)
        setContent {
            MangatoonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                   AppNavigation(viewModel = viewModel)
                }
            }
        }
    }
}

