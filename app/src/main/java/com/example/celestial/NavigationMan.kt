package com.example.Celestial

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.Celestial.loginlogic.LoginViewModel
import com.example.Celestial.loginscreen.LoginScreen
import com.example.Celestial.signupscreen.SignUpScreen
import com.example.finjan.ui.screens.welcome.WelcomeScreen


@Composable
fun NavigationManager(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    NavHost(
        navController = navController,
        startDestination = "splash_screen"
    ) {
//        composable("splash_screen") {
//            SplashScreen(navController)
//        }
        composable("welcome_screen") {
            WelcomeScreen(navController)
        }
//        composable("login_screen") {
//            val loginViewModel = androidx.lifecycle.viewmodel.compose.viewModel<LoginViewModel>()
//            LoginScreen(navController, loginViewModel)
//        }
//        composable("signup_screen") {
//            SignUpScreen(navController)
//        }
//        composable("home") {
//            HomeScreen(navController)
//        }
    }
}