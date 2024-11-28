package com.example.movie_app.models.buttons

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class LeadingIconData (
    @DrawableRes val IconDrawable: Int,
    @StringRes val iconContentDescription: Int
)