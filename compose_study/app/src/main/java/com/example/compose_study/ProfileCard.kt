package com.example.compose_study

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

data class ProfileCard(
    val imageUrl: String,
    val imageDescription: String,
    val author: String,
    val description: String,
)


@Composable
fun CardEx(cardData: ProfileCard) {
    val placeHolderColor = Color(0x33000000)

    Card(
        elevation = CardDefaults.cardElevation(8.dp), // 4dp 높이의 그림자 효과
        modifier = Modifier.padding(4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)
        ) {
            AsyncImage(
                model = cardData.imageUrl,
                contentScale = ContentScale.Crop,
                placeholder = ColorPainter(placeHolderColor),
                contentDescription = cardData.imageDescription,
                modifier = Modifier.size(32.dp).clip(CircleShape)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Column{
                Text(text = cardData.author)
                Text(text = cardData.description)
            }
        }
    }
}
}