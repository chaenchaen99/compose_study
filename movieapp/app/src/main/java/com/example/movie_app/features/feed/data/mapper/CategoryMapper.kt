package com.example.movie_app.features.feed.data.mapper

import com.example.movie_app.features.common.entity.CategoryEntity
import com.example.movie_app.features.common.entity.EntityWrapper
import com.example.movie_app.features.common.entity.MovieDetailEntity
import com.example.movie_app.features.common.mapper.BaseMapper
import com.example.movie_app.features.common.network.model.MovieResponse
import com.example.movie_app.features.feed.data.FeedConstants
import com.example.movie_app.features.feed.domain.enum.SortOrder
import com.example.movie_app.library.storage.IStorage
import javax.inject.Inject

class CategoryMapper @Inject constructor(
    private val storage: IStorage
) : BaseMapper<List<MovieResponse>, List<CategoryEntity>>() {
    override fun getSuccess(
        model: List<MovieResponse>?,
        extra: Any?
    ): EntityWrapper.Success<List<CategoryEntity>> {
        return model?.let {
            EntityWrapper.Success(
                entity = mutableListOf<MovieDetailEntity>()
                    .apply {
                        addAll(model.map { it.toMovieDetailEntity() })
                    }
                    .also {
                        storage.save(FeedConstants.MOVIE_LIST_KEY, it)
                    }
                    .map {
                        it.toMovieThumbnailEntity()
                    }
                    .toCategoryList(if (extra is SortOrder) extra else SortOrder.RATING)
            )
        } ?: EntityWrapper.Success(
            entity = listOf()
        )
    }

    override fun getFailure(error: Throwable): EntityWrapper.Fail<List<CategoryEntity>> {
        return EntityWrapper.Fail(error)
    }
}
