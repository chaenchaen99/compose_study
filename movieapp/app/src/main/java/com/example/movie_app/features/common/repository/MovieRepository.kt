package com.example.movie_app.features.common.repository

import com.example.movie_app.features.common.entity.CategoryEntity
import com.example.movie_app.features.common.entity.EntityWrapper
import com.example.movie_app.features.common.entity.MovieDetailEntity
import com.example.movie_app.features.common.network.IMovieAppNetworkApi
import com.example.movie_app.features.feed.data.FeedConstants
import com.example.movie_app.features.feed.data.mapper.CategoryMapper
import com.example.movie_app.features.feed.domain.enum.SortOrder
import com.example.movie_app.library.storage.IStorage
import javax.inject.Inject

//@Inject를 추가하면 Hilt가 앱 내에서 MovieRepository 객체를 생성할 때, IMovieAppNetworkApi의 인스턴스를 자동으로 주입해준다.
class MovieRepository @Inject constructor(
    private val movieNetworkApi: IMovieAppNetworkApi,
    private val storage: IStorage,
    private val categoryMapper: CategoryMapper,
): IMovieDataSource {
    override suspend fun getCategories(sortOrder: SortOrder?): EntityWrapper<List<CategoryEntity>> {
        return categoryMapper.mapFromResult(
            result = movieNetworkApi.getMovies(),
            extra = sortOrder
        )
    }

    override suspend fun getMovieDetail(movieName: String): MovieDetailEntity {
       return storage.get<List<MovieDetailEntity>>(FeedConstants.MOVIE_LIST_KEY)
           ?.single{ it.title == movieName }
           ?: MovieDetailEntity()
    }

}