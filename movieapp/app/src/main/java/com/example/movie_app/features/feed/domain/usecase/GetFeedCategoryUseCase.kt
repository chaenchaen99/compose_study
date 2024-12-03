package com.example.movie_app.features.feed.domain.usecase

import com.example.movie_app.features.common.entity.CategoryEntity
import com.example.movie_app.features.common.entity.EntityWrapper
import com.example.movie_app.features.common.repository.IMovieDataSource
import com.example.movie_app.features.feed.domain.enum.SortOrder
import javax.inject.Inject

class GetFeedCategoryUseCase @Inject constructor(
    private val dataSource: IMovieDataSource
) : IGetFeedCategoryUseCase {
    override suspend fun invoke(sortOrder: SortOrder?): EntityWrapper<List<CategoryEntity>> {
        return dataSource.getCategories(sortOrder)
    }

}