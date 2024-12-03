package com.example.movie_app.features.feed.domain.usecase

import com.example.movie_app.features.common.entity.CategoryEntity
import com.example.movie_app.features.common.entity.EntityWrapper
import com.example.movie_app.features.feed.domain.enum.SortOrder

interface IGetFeedCategoryUseCase {
    suspend operator fun invoke(sortOrder: SortOrder? = null): EntityWrapper<List<CategoryEntity>>
}