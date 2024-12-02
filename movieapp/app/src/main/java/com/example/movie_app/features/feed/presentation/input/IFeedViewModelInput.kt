package com.example.movie_app.features.feed.presentation.input

interface IFeedViewModelInput {
  fun openDetail(movieName: String)
  fun openInfoDialog()
  fun refreshFeed()
}