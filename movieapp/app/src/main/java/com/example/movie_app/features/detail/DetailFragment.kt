package com.example.movie_app.features.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.movie_app.features.detail.presentation.output.DetailUiEffect
import com.example.movie_app.features.detail.presentation.screen.MovieDetailScreen
import com.example.movie_app.features.detail.presentation.viewModel.MovieDetailViewModel
import com.example.movie_app.ui.navigation.safeNavigate
import com.example.movie_app.ui.theme.MovieappTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private val viewModel : MovieDetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        observeUiEffects()
        init()
        return ComposeView(requireContext()).apply{
            setContent{
                MovieappTheme {
                    MovieDetailScreen(
                        movieDetailState = viewModel.outputs.detailState.collectAsState(),
                        input = viewModel.inputs
                    )
                }
            }
        }
    }

    private fun init() {
        lifecycleScope.launch{
            viewModel.initMovieName(args.movieName)
        }
    }


    private fun observeUiEffects() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.outputs.detailUiEffect.collectLatest {
                    when (it) {
                        is DetailUiEffect.Back -> {
                            findNavController().navigateUp()
                        }

                        is DetailUiEffect.OpenUrl -> {
                            findNavController().safeNavigate(
                                DetailFragmentDirections.actionDetailToImdbDialog(
                                    it.url
                                )
                            )
                        }

                        is DetailUiEffect.RateMovie -> {
                            findNavController().safeNavigate(
                                DetailFragmentDirections.actionDetailToRating(
                                    movieName = it.movieTitle,
                                    rating = it.rating
                                )
                            )
                        }
                    }
                }
            }
        }
    }

}