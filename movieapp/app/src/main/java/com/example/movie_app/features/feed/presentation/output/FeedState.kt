package com.example.movie_app.features.feed.presentation.output

import com.example.movie_app.features.common.entity.CategoryEntity
import com.example.movie_app.features.common.entity.MovieFeedItemEntity

sealed class FeedState{
    //FeedState 클래스의 하위 클래스들은 이 클래스 내에서만 정의될 수 있다.
    object Loading: FeedState() //싱글톤 객체
    class Main(
        val categories : List<CategoryEntity>
    ) : FeedState()
    class Failed(
        val reason : String
    ) : FeedState()
}
