package com.example.celestial

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.celestial.theme.BackgroundColor
import com.example.celestial.theme.CelestialTheme
import com.example.celestial.theme.TextColor


import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(3000)
        navController.navigate("welcome_screen")
    }
    CelestialTheme {
        Column (
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            KawkabBylef()

            Spacer(modifier = Modifier.height(60.dp))
            Text(
                text = "Celestial",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = TextColor,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}