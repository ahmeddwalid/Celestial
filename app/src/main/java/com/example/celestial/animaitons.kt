package com.example.celestial


import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.celestial.R


@Composable
fun KawkabBylef() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.kawkab_bylef))
    val progress by animateLottieCompositionAsState(composition)
    LottieAnimation(
        modifier = Modifier.size(500.dp),
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
}

@Composable
fun SpaceShip() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.makukfada2))
    val progress by animateLottieCompositionAsState(composition)
    LottieAnimation(
        modifier = Modifier.size(500.dp),
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
}

