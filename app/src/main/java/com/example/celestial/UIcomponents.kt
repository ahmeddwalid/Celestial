package com.example.celestial

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.celestial.theme.PrimaryColor
import com.example.celestial.theme.TextColor

import kotlinx.coroutines.launch

@Composable
fun BorderButton(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = PrimaryColor,
    fontSize: Int = 16,
    onClick: () -> Unit
) {
    OutlinedButton (
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(28.dp),
        border = BorderStroke(width = 1.dp, color = color),
        elevation = null
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = TextColor,
                fontSize = fontSize.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}

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
        colors = ButtonDefaults.buttonColors(PrimaryColor),
        shape = RoundedCornerShape(28.dp),
        elevation = null
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = TextColor,
                fontSize = fontSize.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}

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
            .background(PrimaryColor, RoundedCornerShape(rounded.dp))
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
                    color = TextColor,
                    fontSize = fontSize.sp,
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
        textStyle = TextStyle(
            color = TextColor,
            fontSize = fontSize.sp,
        ),
        visualTransformation = if (keyboardType == KeyboardType.Password) PasswordVisualTransformation() else VisualTransformation.None,
    )
}


@Composable
fun Footer(text: String, textButton: String, onClick: @Composable () -> Unit, function: @Composable () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(bottom = 15.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 14.sp,
                color = TextColor,
            )
        )
        TextButton(onClick = { onClick }) {
            Text(
                textButton,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = TextColor,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

//@Composable
//fun SplashScreen() {
//    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.splash_screen))
//    val progress by animateLottieCompositionAsState(composition)
//    LottieAnimation(
//        modifier = Modifier.size(500.dp),
//        composition = composition,
//        // iterations = LottieConstants.IterateForever
//    )
//}

//@Composable
//fun LoaderOne() {
//    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.coffee_beans_loading_zoom))
//    val progress by animateLottieCompositionAsState(composition)
//    LottieAnimation(
//        modifier = Modifier.size(500.dp),
//        composition = composition,
//        iterations = LottieConstants.IterateForever
//    )
//}
//
//@Composable
//fun LoaderTwo() {
//    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.coffee_beans_loading_jump))
//    val progress by animateLottieCompositionAsState(composition)
//    LottieAnimation(
//        modifier = Modifier.size(500.dp),
//        composition = composition,
//        iterations = LottieConstants.IterateForever
//    )
//}
//
//@Composable
//fun CoffeeCup() {
//    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.coffee_cup))
//    val progress by animateLottieCompositionAsState(composition)
//    LottieAnimation(
//        modifier = Modifier.size(400.dp),
//        composition = composition,
//        iterations = LottieConstants.IterateForever
//    )
//}
//
//@Composable
//fun Latte() {
//    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.latte))
//    val progress by animateLottieCompositionAsState(composition)
//    LottieAnimation(
//        modifier = Modifier.size(400.dp),
//        composition = composition,
//        iterations = LottieConstants.IterateForever
//    )
//}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AppTopBar(navController: NavController, title: String, action: Boolean = true) {
//
//    TopAppBar(
//        modifier = Modifier.background(BackgroundColor),
//        title = {
//            Text(
//                text = title,
//                style = TextStyle(
//                    fontSize = 24.sp,
//                    fontFamily = PoppinsFontFamily,
//                    color = primaryFontColor
//                )
//            )
//        },
//        actions = {
//            if (action) {
//                IconButton (
//                    onClick = { navController.navigate("settings_screen") },
//                ) {
//                    Icon(
//                        painter = painterResource(id = com.example.finjan.R.drawable.baseline_settings_24),
//                        contentDescription = "",
//                        tint = primaryFontColor
//                    )
//                }
//            }
//        },
//        // backgroundColor = Color.Transparent,
//    )
//}