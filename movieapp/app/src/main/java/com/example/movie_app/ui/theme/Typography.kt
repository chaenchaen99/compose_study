import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.movie_app.R
import androidx.compose.material3.Typography
import androidx.compose.ui.text.style.TextDecoration


private val spoqaBold = FontFamily(
    Font(R.font.spoqa_han_sans_neo_bold, FontWeight.Bold)
)
private val spoqaRegular = FontFamily(
    Font(R.font.spoqa_han_sans_neo_regular, FontWeight.Normal)
)
private val spoqaThin = FontFamily(
    Font(R.font.spoqa_han_sans_neo_thin, FontWeight.Thin)
)


val typography = Typography(
    titleLarge = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 24.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 20.sp,
    ),
    displayLarge = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 60.sp,
    ),
    displayMedium = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 32.sp,
    ),
    displaySmall = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 24.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 18.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 18.sp,
    ),
    headlineSmall = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 15.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 18.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 15.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 13.sp
    ),
    labelLarge = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 14.sp
    ),
    labelMedium = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 18.sp,
    ),
)


val Typography.h5Title: TextStyle
    @Composable get() = headlineLarge.copy(
        fontSize = 24.sp
    )
val Typography.button: TextStyle
    @Composable get() = headlineMedium.copy(
        fontSize = 18.sp
    )

val Typography.dialogButton: TextStyle
    @Composable get() = headlineMedium.copy(
        fontSize = 18.sp
    )

val Typography.underlinedDialogButton: TextStyle
    @Composable get() = headlineMedium.copy(
        textDecoration = TextDecoration.Underline
    )

val Typography.underlinedButton: TextStyle
    @Composable get() = headlineMedium.copy(
        fontSize = 18.sp,
        textDecoration = TextDecoration.Underline
    )

