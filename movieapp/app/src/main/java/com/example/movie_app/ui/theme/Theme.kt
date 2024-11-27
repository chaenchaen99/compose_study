package com.example.movie_app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import com.example.movie_app.ui.theme.color.ColorSet

private val LocalColors = staticCompositionLocalOf{ ColorSet.Red.LightColors }
@Composable
fun MovieappTheme(
    myColors: ColorSet,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        myColors.DarkColors
    } else {
        myColors.LightColors
    }

    CompositionLocalProvider (LocalColors provides  colors){
        MaterialTheme(
            colorScheme = colors.material,
            typography = Typography,
            content = content
        )
    }
}