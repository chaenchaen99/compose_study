package com.example.movie_app.features.feed.domain.di

import com.example.movie_app.features.feed.domain.usecase.GetFeedCategoryUseCase
import com.example.movie_app.features.feed.domain.usecase.IGetFeedCategoryUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract  class FeedUsecaseModule {
    @Singleton
    @Binds
    abstract  fun bindGetMovieListUsecase(getMovieListUsecase : GetFeedCategoryUseCase) : IGetFeedCategoryUseCase
}