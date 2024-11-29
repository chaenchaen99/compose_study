package com.example.movie_app.ui.components.dialog.components
import androidx.compose.runtime.Composable
import com.example.movie_app.models.dialog.DialogButton
import com.example.movie_app.models.dialog.DialogContent
import com.example.movie_app.models.dialog.DialogText
import com.example.movie_app.models.dialog.DialogTitle
import com.example.movie_app.ui.components.dialog.BaseDialogPopup

@Composable
fun DialogPopup.Rating(
    movieName: String,
    rating: Float,
    buttons: List<DialogButton>
) {
    BaseDialogPopup(
        dialogTitle = DialogTitle.Large("Rate your Score!"),
        dialogContent = DialogContent.Rating(
            DialogText.Rating(
                text = movieName,
                rating = rating
            )
        ),
        buttons = buttons
    )
}
