package com.example.recipes.model

import androidx.annotation.DrawableRes

data class Recipe(
    val name: String,
    val description: String,
    @DrawableRes val image: Int,
    val ingredients: MutableList<Ingredient>,
    val steps: MutableList<String>,
    val cookingTime: String
)