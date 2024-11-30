package com.example.celestial

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.celestial.FilledButton
import com.example.celestial.theme.BackgroundColor
import com.example.celestial.theme.CelestialTheme
import com.example.celestial.theme.TextColor


@Composable
fun WelcomeScreen(navController: NavController) {
    CelestialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Explore the universe, One click at a time!",
                style = TextStyle(
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextColor
                )
            )

            Spacer(modifier = Modifier.height(45.dp))



            FilledButton (
                onClick = {navController.navigate("login_screen")},
                text = "Login",
                modifier = Modifier
                    .padding(horizontal = 34.dp)
            )

            Spacer(modifier = Modifier.height(28.dp))

            FilledButton (
                onClick = {navController.navigate("signup_screen")},
                text = "Create an Account",
                modifier = Modifier
                    .padding(horizontal = 34.dp)
            )
        }
    }
}
