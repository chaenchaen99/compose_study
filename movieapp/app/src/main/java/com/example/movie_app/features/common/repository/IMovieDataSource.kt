package com.example.movie_app.features.common.repository

import com.example.movie_app.features.common.entity.CategoryEntity
import com.example.movie_app.features.common.entity.EntityWrapper
import com.example.movie_app.features.common.entity.MovieDetailEntity
import com.example.movie_app.features.feed.domain.enum.SortOrder


interface IMovieDataSource {
    suspend fun getCategories(sortOrder: SortOrder? = null): EntityWrapper<List<CategoryEntity>>
    suspend fun getMovieDetail(movieName: String): MovieDetailEntity
}