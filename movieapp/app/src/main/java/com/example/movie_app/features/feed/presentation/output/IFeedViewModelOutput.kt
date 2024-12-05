package com.example.movie_app.features.feed.presentation.output

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Singleton

interface IFeedViewModelOutput {
    val feedState : StateFlow<FeedState>
    val feedUiEffect : SharedFlow<FeedUiEffect>
}

sealed class FeedUiEffect {
    data class OpenMovieDetail(val movieName: String) : FeedUiEffect()
    object OpenInfoDialog: FeedUiEffect()
}