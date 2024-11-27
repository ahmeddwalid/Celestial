package com.example.finjan.ui.screens.authentication

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.celestial.SignInLogic
import kotlinx.coroutines.launch


@Composable
fun SignupScreen(navController: NavController, signInLogic: SignInLogic) {
    // Observe the error message from the ViewModel
    val errorMessage = signInLogic.errorMessage

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome Back!",
            style = TextStyle(
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
            )
        )
        Spacer(modifier = Modifier.height(45.dp))

        @OptIn(ExperimentalFoundationApi::class)
        @Composable
        fun AppTextField(
            modifier: Modifier = Modifier,
            hint: String,
            value: String, // Externally controlled value
            onValueChange: (String) -> Unit, // Callback to notify about changes
            keyboardType: KeyboardType = KeyboardType.Text,
            action: ImeAction = ImeAction.Next,
            rounded: Int = 28,
            fontSize: Int = 14,
        ) {
            val bringIntoViewRequester = remember { BringIntoViewRequester() }
            val coroutineScope = rememberCoroutineScope()
            val keyboardController = LocalSoftwareKeyboardController.current
            val focusManager = LocalFocusManager.current

            TextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
                    .onFocusEvent { focusState ->
                        if (focusState.isFocused) {
                            coroutineScope.launch {
                                bringIntoViewRequester.bringIntoView()
                            }
                        }
                    },
                value = value, // Use externally controlled value
                onValueChange = onValueChange, // Notify about changes to the parent
                placeholder = {
                    Text(
                        text = hint,
                        style = TextStyle(
                            color = Color.White,
                            fontSize = fontSize.sp
                        )
                    )
                },
                shape = RoundedCornerShape(rounded.dp),
                keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = action),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) },
                    onDone = {
                        keyboardController?.hide()
                        focusManager.clearFocus()
                    }
                ),
                singleLine = true,
                textStyle = TextStyle(
                    color = Color.White,
                    fontSize = fontSize.sp
                ),
                visualTransformation = if (keyboardType == KeyboardType.Password) PasswordVisualTransformation() else VisualTransformation.None,
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        AppTextField(
            hint = "Password",
            value = signInLogic.password,
            onValueChange = { input -> // Validate and update ViewModel state
                signInLogic.password = input
                signInLogic.isPasswordValid = signInLogic.isEmailValid(input)
            },
            keyboardType = KeyboardType.Password
        )
        Spacer(modifier = Modifier.height(28.dp))

        @Composable
        fun FilledButton(
            modifier: Modifier = Modifier,
            text: String,
            fontSize: Int = 16,
            onClick: () -> Unit
        ) {
            Button(
                modifier = modifier
                    .height(56.dp)
                    .fillMaxWidth(),
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(Color.Blue),
                shape = RoundedCornerShape(28.dp),
                elevation = null
            ) {
                Text(
                    text = text,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = fontSize.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
        }

        // Display the error message in a Snackbar or Text
        if (errorMessage.isNotEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = errorMessage,
                style = TextStyle(color = androidx.compose.ui.graphics.Color.Red)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Hidden back button
        OutlinedButton (onClick = {
            // Navigate back to the previous screen
            navController.popBackStack()
        }) {
            Text(text = "Back")
        }
    }
}
