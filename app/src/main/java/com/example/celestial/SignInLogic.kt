package com.example.celestial

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SignInLogic : ViewModel() {
    private val validCredentials = mapOf(
        "ahmed@gmail.com" to "FinjanA",
        "noureen@gmail.com" to "FinjanN",
        "shahd@gmail.com" to "FinjanS"
    )

    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var errorMessage by mutableStateOf("")
    var isEmailValid by mutableStateOf(true) // Tracks email validation state
    var isPasswordValid by mutableStateOf(true) // Tracks password validation state

    fun isEmailValid(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
        return email.matches(emailRegex.toRegex())
    }

    fun isPasswordValid(password: String): Boolean {
        return password.length >= 8
    }

    fun authenticate(): Boolean {
        val username = email.trim().lowercase()
        val userPassword = password
        return if (validCredentials[username] == userPassword) {
            true
        } else {
            errorMessage = "Invalid input"
            false
        }
    }
}