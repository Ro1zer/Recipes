package com.example.recipes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recipes.model.Ingredient
import com.example.recipes.model.Recipe
import com.example.recipes.ui.theme.RecipesTheme

@Composable
fun RecipeListItem(
    recipe: Recipe,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding
    ) {
        item {
            Text(
                text = stringResource(R.string.ingredients),
                style = MaterialTheme.typography.displayLarge
            )
        }
        ingredientsListItem(recipe.ingredients)
        item {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.instruction),
                    style = MaterialTheme.typography.displayLarge,
                    textAlign = TextAlign.End
                )
            }
        }
        instructionListItem(recipe.steps)
    }
}

fun LazyListScope.ingredientsListItem(ingredients: List<Ingredient>) {
    items(ingredients) {
        Row(
            modifier = Modifier
                .padding(vertical = dimensionResource(R.dimen.padding_extra_small))
                .clip(RoundedCornerShape(dimensionResource(R.dimen.padding_small)))
                .background(MaterialTheme.colorScheme.primaryContainer),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (!it.weight.isEmpty()) {
                Text(
                    text = it.weight,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Spacer(Modifier.width(dimensionResource(R.dimen.padding_extra_extra_small)))
            }
            Text(
                text = it.name,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

fun LazyListScope.instructionListItem(steps: List<String>) {
    itemsIndexed(steps) { index, step ->
        Row(
            modifier = Modifier
                .padding(vertical = dimensionResource(R.dimen.padding_small))
        ) {
            Box(
                modifier = Modifier
                    .size(dimensionResource(R.dimen.item_size))
                    .clip(RoundedCornerShape(dimensionResource(R.dimen.padding_large)))
                    .background(MaterialTheme.colorScheme.tertiaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = (index + 1).toString(),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                )
            }
            Spacer(Modifier.width(dimensionResource(R.dimen.padding_extra_extra_small)))
            Text(
                text = step,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview(
    "Light"
)
@Composable
fun RecipeListItemLightPreview() {
    RecipesTheme(
        dynamicColor = false
    ) {
        RecipeListItem(
            recipe = Recipe(
                ingredients = mutableListOf(
                    Ingredient(
                        name = "молода картопля дрібна",
                        weight = "0,5 кг"
                    ),
                    Ingredient(
                        name = "Кріп",
                        weight = "0,5 пучка"
                    ),
                    Ingredient(
                        name = "Сіль",
                        weight = "0,5 ч.л"
                    ),
                    Ingredient(
                        name = "Перець чорний свежомолотий",
                        weight = "0,5 ч.л"
                    ),
                    Ingredient(
                        name = "Олія для смаження",
                        weight = ""
                    )
                ),
                steps = mutableListOf(
                    "Ароматна молода картопля з підсмаженою скоринкою зовні і ніжною, трохи солодкуватою м'якоттю всередині. Начебто все просто, але є дрібниці, які забезпечать успіх цієї страви з використанням мінімальної кількості олії. Раджу їх не ігнорувати і тоді результат буде завжди незрівнянним.",
                    "Ця страва з розряду тих, у яких потрібно попередньо ретельно підготувати всі продукти, а потім уже все готується досить швидко.",
                    "Картоплю беремо дрібну. Не більший за волоський горіх. Найскладніше це її почистити. В принципі можна не чистити, а дуже добре його помити. Але мої домашні вважають за краще все-таки почищену картоплю. Раджу при чищенні одягнути рукавички, щоб не почорніли пальці.Почищену картоплю добре промиваємо. Наразі дуже важливий момент. Картоплю необхідно дуже добре просушити паперовими рушниками. Це для гарної золотистої скоринки.",
                    "Тепер підготуємо спеції. З кропу обриваємо листочки. Часник чистим. У моїй родині всі люблять часник, тому я його беру чимало. А так кожен хай бере на свій смак.Часник та кріп дрібно рубаємо.Змішуємо разом і поки що відставляємо.",
                    "Тепер готуємо перечно-сольову пудру. Беремо одну-дві чайні ложки солі та чорний перець горошком за смаком. Для дітей перець не можна додавати.Перетираємо сіль та перець у ступці в пудру. Якщо немає ступки, то для отримання сольової пудри можна скористатися кавомолкою і додати чорний мелений перець. Але свіжомелений - завжди набагато краще.",
                    "У принципі, все готове і можна приступати до смаження. Для цього нам потрібна глибока сковорода чи сотейник із кришкою. Кришка тут також обов'язкова. Сотейник у мене старенький і бачив види, так, що заздалегідь перепрошую його зовнішній вигляд, але він для приготування цієї страви підходить ідеально. Наливаємо на дно рослинну олію шаром близько 0,5 см. Не більше. Добре розігріваємо олію.",
                    "Кидаємо туди картоплю, накриваємо сотейник кришкою і добре перетрушуємо, щоб картопля повністю покрилася олією. НЕ СОЛИТИ!!!!!!!! Це також важливо. Сіль сприяє виділенню соку і в нас може вийти каша.Смажимо на середньому вогні під кришкою, періодично перетрушуючи сотейник. Спочатку картопля буде дзвінко стукати об стінки сотейника при перетрушуванні, потім звук буде дедалі глухім. Це важко описати, але коли смажитимете – зрозумієте. Готовність перевіряємо дерев'яною шпажкою чи ножем.",
                    "Коли картопля буде готова - солимо її перечно-сольової пудрою і засипаємо зелень з часником. Все добре перемішуємо, знову накриваємо кришкою і даємо настоятися 5 хвилин.",
                    "Все! Можна насолоджуватися ніжною картопелькою!Смачного!"
                )
            )
        )
    }
}

@Preview(
    "Light"
)
@Composable
fun RecipeListItemBlackPreview() {
    RecipesTheme(
        darkTheme = true,
        dynamicColor = false
    ) {
        RecipeListItem(
            recipe = Recipe(
                ingredients = mutableListOf(
                    Ingredient(
                        name = "молода картопля дрібна",
                        weight = "0,5 кг"
                    ),
                    Ingredient(
                        name = "Кріп",
                        weight = "0,5 пучка"
                    ),
                    Ingredient(
                        name = "Сіль",
                        weight = "0,5 ч.л"
                    ),
                    Ingredient(
                        name = "Перець чорний свежомолотий",
                        weight = "0,5 ч.л"
                    ),
                    Ingredient(
                        name = "Олія для смаження",
                        weight = ""
                    )
                ),
                steps = mutableListOf(
                    "Ароматна молода картопля з підсмаженою скоринкою зовні і ніжною, трохи солодкуватою м'якоттю всередині. Начебто все просто, але є дрібниці, які забезпечать успіх цієї страви з використанням мінімальної кількості олії. Раджу їх не ігнорувати і тоді результат буде завжди незрівнянним.",
                    "Ця страва з розряду тих, у яких потрібно попередньо ретельно підготувати всі продукти, а потім уже все готується досить швидко.",
                    "Картоплю беремо дрібну. Не більший за волоський горіх. Найскладніше це її почистити. В принципі можна не чистити, а дуже добре його помити. Але мої домашні вважають за краще все-таки почищену картоплю. Раджу при чищенні одягнути рукавички, щоб не почорніли пальці.Почищену картоплю добре промиваємо. Наразі дуже важливий момент. Картоплю необхідно дуже добре просушити паперовими рушниками. Це для гарної золотистої скоринки.",
                    "Тепер підготуємо спеції. З кропу обриваємо листочки. Часник чистим. У моїй родині всі люблять часник, тому я його беру чимало. А так кожен хай бере на свій смак.Часник та кріп дрібно рубаємо.Змішуємо разом і поки що відставляємо.",
                    "Тепер готуємо перечно-сольову пудру. Беремо одну-дві чайні ложки солі та чорний перець горошком за смаком. Для дітей перець не можна додавати.Перетираємо сіль та перець у ступці в пудру. Якщо немає ступки, то для отримання сольової пудри можна скористатися кавомолкою і додати чорний мелений перець. Але свіжомелений - завжди набагато краще.",
                    "У принципі, все готове і можна приступати до смаження. Для цього нам потрібна глибока сковорода чи сотейник із кришкою. Кришка тут також обов'язкова. Сотейник у мене старенький і бачив види, так, що заздалегідь перепрошую його зовнішній вигляд, але він для приготування цієї страви підходить ідеально. Наливаємо на дно рослинну олію шаром близько 0,5 см. Не більше. Добре розігріваємо олію.",
                    "Кидаємо туди картоплю, накриваємо сотейник кришкою і добре перетрушуємо, щоб картопля повністю покрилася олією. НЕ СОЛИТИ!!!!!!!! Це також важливо. Сіль сприяє виділенню соку і в нас може вийти каша.Смажимо на середньому вогні під кришкою, періодично перетрушуючи сотейник. Спочатку картопля буде дзвінко стукати об стінки сотейника при перетрушуванні, потім звук буде дедалі глухім. Це важко описати, але коли смажитимете – зрозумієте. Готовність перевіряємо дерев'яною шпажкою чи ножем.",
                    "Коли картопля буде готова - солимо її перечно-сольової пудрою і засипаємо зелень з часником. Все добре перемішуємо, знову накриваємо кришкою і даємо настоятися 5 хвилин.",
                    "Все! Можна насолоджуватися ніжною картопелькою!Смачного!"
                )
            )
        )
    }
}
