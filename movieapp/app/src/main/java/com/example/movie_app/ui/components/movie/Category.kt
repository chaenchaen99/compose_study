package com.example.movie_app.ui.components.movie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.movie_app.features.common.entity.CategoryEntity
import com.example.movie_app.features.feed.presentation.input.IFeedViewModelInput
import com.example.movie_app.ui.theme.MovieappTheme
import com.example.movie_app.ui.theme.Paddings
import h5Title


@Composable
fun CategoryRow(
    categoryEntity: CategoryEntity,
    input: IFeedViewModelInput,
) {
    Column() {
        CategoryTitle(categoryEntity.genre)
        LazyRow(
            contentPadding = PaddingValues(
                horizontal = Paddings.large
            )
        ) {
            itemsIndexed(categoryEntity.movieDetailEntities){_, item ->
                MovieItem(
                    movie = item,
                    input = input,
                )
            }

        }
    }
}

@Composable
fun CategoryTitle(titleName: String) {
    Text(
        text = titleName,
        modifier = Modifier.padding(
            vertical = Paddings.large,
            horizontal = Paddings.extra),
        style = MaterialTheme.typography.h5Title
    )
}

