package com.example.movie_app.features.common.repository

import com.example.movie_app.features.common.network.IMovieAppNetworkApi
import com.example.movie_app.library.network.model.ApiResponse
import timber.log.Timber
import javax.inject.Inject

//@Inject를 추가하면 Hilt가 앱 내에서 MovieRepository 객체를 생성할 때, IMovieAppNetworkApi의 인스턴스를 자동으로 주입해준다.
class MovieRepository @Inject constructor(
    private val movieNetworkApi: IMovieAppNetworkApi
): IMovieDataSource {
    override suspend fun getMovieList() {
       val data = movieNetworkApi.getMovies().response
        if(data is ApiResponse.Success){
            val movieList = data.data
        }
    }
}