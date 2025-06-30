package com.example.recipes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipes.repository.DishesRepository
import com.example.recipes.ui.theme.RecipesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipesTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar()
                    }
                ) { innerPadding ->
                    DishesListItem(
                        dishes = DishesRepository.dishes,
                        contentPadding = innerPadding
                    )
                    //TODO: (1) Make a soft transition to Recipe by button on Dish
//                    RecipeListItem(
//                        recipe = DishesRepository.dishes.first().recipe,
//                        contentPadding = innerPadding,
//                        modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
//                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.app_logo),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

@Preview(
    "LightTheme"
)
@Composable
fun TopAppBarLightThemePreview() {
    RecipesTheme(
        dynamicColor = false
    ) {
        TopAppBar()
    }
}

@Preview(
    "BlackTheme"
)
@Composable
fun TopAppBarBlackThemePreview() {
    RecipesTheme(
        darkTheme = true,
        dynamicColor = false
    ) {
        TopAppBar()
    }
}