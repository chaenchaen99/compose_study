package com.example.movie_app.features.common.di

import com.example.movie_app.features.common.network.IMovieAppNetworkApi
import com.example.movie_app.features.common.network.MovieAppNetworkApi
import com.example.movie_app.features.common.repository.IMovieDataSource
import com.example.movie_app.features.common.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module // @Module은 이 클래스가 Hilt 모듈임을 나타내는 것
@InstallIn(SingletonComponent::class) //  @InstallIn 어노테이션은 이 모듈이 특정 컴포넌트에 설치된다는 것 -> 싱글톤 범위로 의존성을 제공한다.
abstract class MovieDataModule {

    @Singleton
    @Binds //인터페이스와 구현 클래스 간의 의존성 연결을 설정하는 데 사용된다.
    abstract fun bindMovieRepository(movieRepository: MovieRepository): IMovieDataSource

    @Singleton
    @Binds
    abstract fun bindNetwork(networkApi: MovieAppNetworkApi): IMovieAppNetworkApi

}
