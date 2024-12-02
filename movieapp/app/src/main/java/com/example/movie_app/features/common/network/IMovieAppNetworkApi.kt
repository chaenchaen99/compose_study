package com.example.movie_app.features.common.network

import com.example.movie_app.features.common.network.model.MovieResponse
import com.example.movie_app.library.network.model.ApiResult

interface IMovieAppNetworkApi {
    suspend fun getMovies(): ApiResult<List<MovieResponse>>
}