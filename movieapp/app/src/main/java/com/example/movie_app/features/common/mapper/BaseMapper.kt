package com.example.movie_app.features.common.mapper

import com.example.movie_app.features.common.entity.EntityWrapper
import com.example.movie_app.library.network.model.ApiResponse
import com.example.movie_app.library.network.model.ApiResult


abstract class BaseMapper<M, E> {

    fun mapFromResult(result: ApiResult<M>, extra: Any? = null): EntityWrapper<E> =
        when (result.response) {
            is ApiResponse.Success -> getSuccess(model = result.response.data, extra = extra)
            is ApiResponse.Fail -> getFailure(error = result.response.error)
        }

    abstract fun getSuccess(model: M?, extra: Any?): EntityWrapper.Success<E>

    abstract fun getFailure(error: Throwable): EntityWrapper.Fail<E>
}
