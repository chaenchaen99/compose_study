package com.example.movie_app.features.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.movie_app.features.feed.presentation.screen.FeedScreen
import com.example.movie_app.features.feed.presentation.viewmodel.FeedViewModel
import com.example.movie_app.ui.theme.MovieappTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedFragment : Fragment() {

    private val viewModel : FeedViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply{
            setContent{
                FeedScreen(
                    feedStateHolder = viewModel.output.feedState.collectAsState(),
                    input = viewModel.input,

                )
            }
        }
    }
}