package com.example.movie_app.ui.theme.color

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
val Red200 = Color(0xFFFFAAAA)
val Red300 = Color(0xFFCC5942)
val Red400 = Color(0xFFFF5258)
val Red700 = Color(0xFFEC0000)
val Red800 = Color(0xFFAF0000)
val Red900 = Color(0xFF531F1C)
val Green400 = Color(0xFF55D800)
val Blue400 = Color(0xFF395DE8)
val Grey200 = Color(0xFF908499)
val Grey900 = Color(0xFF151515)
val Black = Color(0xFF000000)

val White100 = Color(0xFFFFFFFF)
val Beige100 = Color(0xFFFDF7F4)
val Green100 = Color(0xFF8EB486)
val Brown100 = Color(0xFF997C70)
val DarkBrown100 = Color(0xFF685752)

sealed class ColorSet {
    open lateinit var LightColors: MyColors
    open lateinit var DarkColors: MyColors

    object Brown : ColorSet() {
        override var LightColors = MyColors(
            material = lightColorScheme(
                primary = Green100,
                primaryContainer = Beige100,
                onPrimary = White100,
                secondary = Brown100,
                onSecondary = White100,
                tertiary = DarkBrown100,
                onTertiary = White100,
                surface = White100,
                onSurface = Black,
                background = Grey900,
                onBackground = Black,
                error = Red400,
            ),
            success = Green400,
            disabledSecondary = Grey200,
            textFiledBackground = Grey200
        )

        override var DarkColors = MyColors(
            material = darkColorScheme(
                primary = Grey900,
                onPrimary = White100,
                primaryContainer = Grey900,
                secondary = Grey900,
                onSecondary = White100,
                tertiary = DarkBrown100,
                onTertiary = White100,
                surface = White100,
                onSurface = Black,
                background = Black,
                onBackground = White100,
                error = Red400,
            )
        )
    }

    object Blue : ColorSet() {
        override var LightColors = MyColors(
            material = lightColorScheme(
                primary = Blue400,
                onPrimary = White100,
                primaryContainer = Grey900,
                secondary = Grey900,
                onSecondary = White100,
                tertiary = DarkBrown100,
                onTertiary = White100,
                surface = White100,
                onSurface = DarkBrown100,
                background = White100,
                onBackground = DarkBrown100,
                error = Red400,
            ),
            success = Green400,
            disabledSecondary = DarkBrown100,
            textFiledBackground = Grey200
        )

        override var DarkColors = MyColors(
            material = darkColorScheme(
                primary = Grey900,
                onPrimary = White100,
                primaryContainer = Grey900,
                secondary = Grey900,
                onSecondary = White100,
                tertiary = DarkBrown100,
                onTertiary = White100,
                surface = White100,
                onSurface = DarkBrown100,
                background = White100,
                onBackground = DarkBrown100,
                error = Red400,
            )
        )
    }
}