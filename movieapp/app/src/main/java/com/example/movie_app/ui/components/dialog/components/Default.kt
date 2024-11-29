package com.example.movie_app.ui.components.dialog.components
import androidx.compose.runtime.Composable
import com.example.movie_app.models.dialog.DialogButton
import com.example.movie_app.models.dialog.DialogContent
import com.example.movie_app.models.dialog.DialogText
import com.example.movie_app.models.dialog.DialogTitle
import com.example.movie_app.ui.components.dialog.BaseDialogPopup

object DialogPopup

@Composable
fun DialogPopup.Default(
    title: String,
    bodyText: String,
    buttons: List<DialogButton>
) {
    BaseDialogPopup(
        dialogTitle = DialogTitle.Default(title),
        dialogContent = DialogContent.Default(
            DialogText.Default(bodyText)
        ),
        buttons = buttons
    )
}
