package com.example.movie_app.features.common.repository

interface IMovieDataSource {
    suspend fun getMovieList()
}