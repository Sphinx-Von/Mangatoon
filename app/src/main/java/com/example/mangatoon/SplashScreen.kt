package com.example.mangatoon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavController
import com.example.mangatoon.ui.theme.Periwinkle
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController : NavController){
    LaunchedEffect(key1 = true) {
        delay(3000L) // 3 seconds delay for splash screen
        navController.navigate("home") {
            popUpTo("splash_screen") { inclusive = true } // Clear back stack
        }
    }

    // Splash Screen UI
    Box(
        modifier = Modifier
            .fillMaxSize().background(Periwinkle),
        contentAlignment = Alignment.Center

    ) {
        Column(horizontalAlignment =  Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.splash_logo)
                , contentDescription = "App Logo" ,
                modifier = Modifier.size(150.dp))
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Mangatoon",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
                )
        }
    }
}