package com.example.celestial

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.finjan.ui.screens.authentication.SignupScreen

@Composable
fun NavigationManager(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    NavHost(
        navController = navController,
        startDestination = "splash_screen"
    ) {
        composable("splash_screen") {
            SplashScreen(navController)
        }
        composable("login_screen") {
            LoginScreen(navController)
        }
        composable("signup_screen") {
            val SignInLogic = androidx.lifecycle.viewmodel.compose.viewModel<SignInLogic>()
            SignupScreen(navController, SignInLogic)
        }
        composable("home") {
            HomeScreen(navController)
        }
    }
}