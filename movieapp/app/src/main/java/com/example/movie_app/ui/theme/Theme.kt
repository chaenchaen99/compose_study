package com.example.movie_app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import com.example.movie_app.ui.theme.color.ColorSet
import com.example.movie_app.ui.theme.color.MyColors

private val LocalColors = staticCompositionLocalOf{ ColorSet.Brown.LightColors }
@Composable
fun MovieappTheme(
    myColors: ColorSet = ColorSet.Brown,
    typoGraphy: Typography = typography,
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
            typography = typoGraphy,
            content = content
        )
    }
}

val MaterialTheme.colorScheme: MyColors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current