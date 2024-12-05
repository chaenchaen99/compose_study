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
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.example.movie_app.features.feed.presentation.output.FeedUiEffect
import com.example.movie_app.features.feed.presentation.screen.FeedScreen
import com.example.movie_app.features.feed.presentation.viewmodel.FeedViewModel
import com.example.movie_app.ui.navigation.safeNavigate
import com.example.movie_app.ui.theme.MovieappTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FeedFragment : Fragment() {

    private val viewModel : FeedViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        observeUiEffects()
        return ComposeView(requireContext()).apply{
            setContent{
                FeedScreen(
                    feedStateHolder = viewModel.output.feedState.collectAsState(),
                    input = viewModel.input,

                )
            }
        }
    }

    private fun observeUiEffects() {
        val navController = findNavController()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.output.feedUiEffect.collectLatest { //가장 최근에 들어온 값을 가져오겠다
                    when (it) {
                        is FeedUiEffect.OpenMovieDetail -> {
                            navController.safeNavigate(
                                FeedFragmentDirections.actionFeedToDetail(it.movieName)
                            )
                        }

                        is FeedUiEffect.OpenInfoDialog -> {
//                            navController.safeNavigate(
//                                FeedFragmentDirections.actionFeedToInfo()
//                            )
                        }
                    }
                }
            }
        }
    }
}




