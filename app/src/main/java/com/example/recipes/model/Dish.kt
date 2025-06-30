package com.example.recipes.model

import androidx.annotation.DrawableRes

data class Dish(
    val name: String,
    val description: String,
    @DrawableRes val image: Int,
    val timeEstimate: String,
    val recipe: Recipe = Recipe(mutableListOf(), mutableListOf())
)