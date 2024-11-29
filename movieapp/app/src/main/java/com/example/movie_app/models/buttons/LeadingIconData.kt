package com.example.movie_app.models.buttons

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class LeadingIconData (
    @DrawableRes val iconDrawable: Int,
    @StringRes val iconContentDescription: Int?
)