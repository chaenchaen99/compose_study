package com.example.movie_app.ui.components.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.movie_app.ui.components.dialog.components.button.DialogButtonsColumn
import com.example.movie_app.ui.components.dialog.components.content.DialogContentWrapper
import com.example.movie_app.ui.components.dialog.components.title.DialogTitleWrapper
import com.example.movie_app.models.dialog.DialogButton
import com.example.movie_app.models.dialog.DialogContent
import com.example.movie_app.models.dialog.DialogText
import com.example.movie_app.models.dialog.DialogTitle
import com.example.movie_app.ui.theme.MovieappTheme
import com.example.movie_app.ui.theme.Paddings

@Composable
fun BaseDialogPopup(
    dialogTitle: DialogTitle? = null,
    dialogContent: DialogContent? = null,
    buttons: List<DialogButton>? = null,
){
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(Paddings.none),
        colors = CardDefaults.cardColors(contentColor = MaterialTheme.colorScheme.background),
        shape = MaterialTheme.shapes.large,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            dialogTitle?.let{
                DialogTitleWrapper(it)
            }

            Column (
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxWidth()
                    .padding(
                        start = Paddings.xlarge,
                        end = Paddings.xlarge,
                        bottom = Paddings.xlarge
                    )
            ){
                dialogContent?.let{ DialogContentWrapper(it) }
                buttons?.let { DialogButtonsColumn(it) }
            }
        }
    }
}

@Preview
@Composable
fun BaseDialogPopupPreview() {
    MovieappTheme {
        BaseDialogPopup(
            dialogTitle = DialogTitle.Header("TITLE"),
            dialogContent = DialogContent.Large(DialogText.Default("abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc")),
            buttons = listOf(
                DialogButton.Primary("Okay"){}
            )
        )
    }
}

@Preview
@Composable
fun BaseDialogPopupPreview2() {
    MovieappTheme {
        BaseDialogPopup(
            dialogTitle = DialogTitle.Header("TITLE"),
            dialogContent = DialogContent.Large(DialogText.Default("abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc")),
            buttons = listOf(
                DialogButton.Secondary("Okay"){},
                DialogButton.UnderlinedText("Cancel"){},
            )
        )
    }
}

@Preview
@Composable
fun BaseDialogPopupPreview3() {
    MovieappTheme {
        BaseDialogPopup(
            dialogTitle = DialogTitle.Large("TITLE"),
            dialogContent = DialogContent.Rating(DialogText.Rating(text = "반지의 제왕", rating =   4.5f)),
            buttons = listOf(
                DialogButton.Secondary("Okay"){},
                DialogButton.UnderlinedText("Cancel"){},
            )
        )
    }
}