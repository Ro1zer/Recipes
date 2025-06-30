package com.example.recipes.model

data class Recipe(
    val ingredients: MutableList<Ingredient>,
    val steps: MutableList<String>,
)