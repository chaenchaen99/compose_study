package com.example.movie_app.ui.components.movie

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movie_app.R
import com.example.movie_app.ui.theme.Paddings


private val CARD_WIDTH = 150.dp
private val CARD_HEIGHT = 200.dp
private val ICON_SIZE = 12.dp

@Composable
fun MovieItem(
) {
    Column(
        modifier = Modifier
            .width(CARD_WIDTH)
            .padding(Paddings.large)
    ) {
        Poster()

        Text(
            text = "반지의 제왕",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(
                top = Paddings.large,
            ),
            style = MaterialTheme.typography.bodyMedium
        )

        Row(
            modifier = Modifier.padding(
                vertical = Paddings.medium
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .padding(Paddings.small)
                    .size(ICON_SIZE),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_rating),
                tint = MaterialTheme.colorScheme.onSurface.copy(
                    alpha = 0.5f
                ),
                contentDescription = "rating icon" //이 이미지가 어떤 이미지인지 알려주는 역할
            )
            Text(
                text = "5.0",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(
                    alpha = 0.5f
                )
            )
        }
    }
}


@Composable
fun Poster(

) {
    Card() {
        Box(
            modifier = Modifier
                .width(CARD_WIDTH)
                .height(CARD_HEIGHT),
        )
    }
}

@Preview
@Composable
fun MovieItemPreview() {
    MovieItem()
}