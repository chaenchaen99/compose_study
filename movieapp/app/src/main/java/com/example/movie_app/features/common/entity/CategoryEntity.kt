package com.example.movie_app.features.common.entity

data class CategoryEntity(
    val id: Int,
    val genre: String,
    val movieDetailEntities: List<MovieFeedItemEntity>,
)