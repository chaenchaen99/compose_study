package com.example.movie_app.features.detail.domain.usecase

import com.example.movie_app.features.common.entity.MovieDetailEntity


interface IGetMovieDetailUseCase {
    suspend operator fun invoke(name: String): MovieDetailEntity
}
