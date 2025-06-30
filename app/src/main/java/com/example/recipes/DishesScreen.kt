package com.example.recipes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recipes.model.Dish
import com.example.recipes.repository.DishesRepository
import com.example.recipes.ui.theme.RecipesTheme

@Composable
fun DishesListItem(
    dishes: List<Dish>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding
    ) {
        items(dishes) {
            DishCardItem(
                dish = it,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
            )
        }
    }
}

@Composable
fun DishCardItem(
    dish: Dish,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
    ) {
        Column {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(dish.image),
                    contentScale = ContentScale.FillWidth,
                    contentDescription = null
                )
            }
            Column(
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
            ) {
                Text(
                    text = dish.name,
                    style = MaterialTheme.typography.displayLarge
                )
                Spacer(Modifier.height(dimensionResource(R.dimen.padding_small)))
                Text(
                    text = dish.description,
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Justify
                )
                Spacer(Modifier.height(dimensionResource(R.dimen.padding_super_large)))
                Text(
                    text = dish.timeEstimate,
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(Modifier.height(dimensionResource(R.dimen.padding_medium)))
                OutlinedButton(
                    onClick = { /*TODO:*/ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier.padding(
                            horizontal = dimensionResource(R.dimen.padding_large),
                            vertical = dimensionResource(R.dimen.padding_small)
                        ),
                        text = stringResource(R.string.view_button).uppercase(),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

        }
    }
}

@Preview(
    "LightTheme"
)
@Composable
fun DishCardItemLightThemePreview() {
    RecipesTheme(
        dynamicColor = false
    ) {
        DishCardItem(
            dish = Dish(
                name = "Пікантний салатик до шашличку",
                description = "Ще один ніжний салат з моєї колекції. Поєднання солодкого винограду, чері, моцарелли і пікантної заправки! І готується за лічені хвилини.",
                image = R.drawable.recipe_2,
                timeEstimate = "30 хвилин"
            )
        )
    }
}

@Preview(
    "BlackTheme"
)
@Composable
fun DishCardItemBlackThemePreview() {
    RecipesTheme(
        darkTheme = true,
        dynamicColor = false
    ) {
        DishCardItem(
            dish = Dish(
                name = "Пікантний салатик до шашличку",
                description = "Ще один ніжний салат з моєї колекції. Поєднання солодкого винограду, чері, моцарелли і пікантної заправки! І готується за лічені хвилини.",
                image = R.drawable.recipe_2,
                timeEstimate = "30 хвилин"
            )
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PHONE
)
@Composable
fun DishesListItemPreview() {
    RecipesTheme(
        dynamicColor = false
    ) {
        DishesListItem(
            dishes = DishesRepository.dishes
        )
    }
}