package com.example.movie_app.ui.components.movie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.movie_app.ui.theme.Paddings
import com.example.movie_app.ui.theme.colorScheme
import com.example.movie_app.ui.util.getAnnotatedText
import h5Title

@Composable
fun MovieMeta(
    modifier: Modifier = Modifier,
    key: String,
    value: String
) {
    Column(modifier = modifier) {
        // Key
        Text(
            text = key,
            style = MaterialTheme.typography.bodyLarge.copy(Color.DarkGray),
        )

        // Value
        Text(
            text = getAnnotatedText(text = value),
            style = MaterialTheme.typography.bodyMedium.copy(Color.DarkGray)
        )

        Spacer(modifier = Modifier.height(Paddings.large))
    }
}
