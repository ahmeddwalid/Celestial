package com.example.celestial

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val validCredentials = mapOf(
        "mina@gmail.com" to "password0",
        "ash@gmail.com" to "password1",
        "mohanad@gmail.com" to "password2"
    )

    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var errorMessage by mutableStateOf("")
    var isEmailValid by mutableStateOf(true)
    var isPasswordValid by mutableStateOf(true)

    fun isEmailValid(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
        return email.matches(emailRegex.toRegex())
    }

    fun isPasswordValid(password: String): Boolean {
        return password.length >= 8
    }

    fun authenticate(): Boolean {
        val username= email.trim().lowercase()
        val userPassword = password
        return if (validCredentials[username] == userPassword) {
            true
        } else {
            errorMessage = "Invalid input"
            false
        }
    }
}
