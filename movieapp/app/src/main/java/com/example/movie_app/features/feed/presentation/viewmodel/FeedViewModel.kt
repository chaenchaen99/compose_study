package com.example.movie_app.features.feed.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movie_app.features.common.repository.IMovieDataSource
import com.example.movie_app.features.feed.presentation.input.IFeedViewModelInput
import com.example.movie_app.features.feed.presentation.output.FeedState

import com.example.movie_app.features.feed.presentation.output.FeedUiEffect
import com.example.movie_app.features.feed.presentation.output.IFeedViewModelOutput
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val movieRepository: IMovieDataSource,
    override val feedUiEffect: SharedFlow<FeedUiEffect>
) : ViewModel(), IFeedViewModelOutput, IFeedViewModelInput {


    private val _feedState: MutableStateFlow<FeedState> = MutableStateFlow(FeedState.Loading)
    override val feedState: StateFlow<FeedState>
        get() = _feedState

    //유저로부터 입력을 받아 fragment 단에서 액션을 수행하기 위한 flow
    private val _feedUIEffect = MutableSharedFlow<FeedUiEffect>(replay = 0)
    val feedUiState: SharedFlow<FeedUiEffect>
        get() = _feedUIEffect

    fun getMovies() {
        viewModelScope.launch {
            movieRepository.getMovieList()
        }
    }

    override fun openDetail(movieName: String) {
        TODO("Not yet implemented")
    }

    override fun openInfoDialog() {
        TODO("Not yet implemented")
    }

    override fun refreshFeed() {
        TODO("Not yet implemented")
    }
}