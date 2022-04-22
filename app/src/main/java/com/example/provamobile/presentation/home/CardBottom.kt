package com.example.provamobile.presentation.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.provamobile.R
import com.example.provamobile.presentation.components.Section
import com.example.provamobile.presentation.theme.Gray55
import com.example.provamobile.presentation.theme.Gray75
import com.example.provamobile.presentation.theme.GrayE0
import com.example.provamobile.presentation.theme.PrimaryColor
import com.example.rocketreserver.AllBooksQuery
import com.example.rocketreserver.CategoriesQuery
import com.example.rocketreserver.FavoriteAuthorsQuery

@Composable
fun CardBottom(
    favoriteAuthors: List<FavoriteAuthorsQuery.FavoriteAuthor>?,
    categories: List<CategoriesQuery.AllBook>?,
    allBooks: List<AllBooksQuery.AllBook>?,
    onBookClicked: (String) -> Unit
) {
    val current = LocalContext.current
    Card(shape = RoundedCornerShape(topStart = 32.dp)) {
        Column(modifier = Modifier.padding(vertical = 32.dp)) {
            Section(text = R.string.favorite_authors)

            Spacer(modifier = Modifier.height(20.dp))

            LazyRow(
                contentPadding = PaddingValues(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                items(favoriteAuthors ?: listOf()) {
                    Card(
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(width = 1.dp, color = GrayE0),
                        modifier = Modifier
                            .width(250.dp)
                            .height(69.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(20.dp)
                        ) {
                            AsyncImage(
                                model = it.picture,
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .width(63.dp)
                                    .height(67.dp)
                                    .clip(RoundedCornerShape(8.dp))
                            )
                            Column(verticalArrangement = Arrangement.Center) {
                                Text(
                                    text = it.name,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Gray55
                                )
                                Text(
                                    text = current.resources.getQuantityString(
                                        R.plurals.books_count,
                                        it.booksCount,
                                        it.booksCount
                                    ),
                                    fontSize = 14.sp,
                                    color = Gray75
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Section(text = R.string.library, showAll = false)

            Spacer(modifier = Modifier.height(20.dp))

            val lista = categories
                ?.distinct()
                ?.map { name ->
                    name.category.name
                        .lowercase()
                        .replaceFirstChar {
                            it.uppercase()
                        }
                }
                ?.sorted()

            LazyRow(
                contentPadding = PaddingValues(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                item {
                    CustomChip(text = stringResource(id = R.string.all), selected = true)
                }
                items(lista ?: listOf()) {
                    CustomChip(text = it, selected = false)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                allBooks?.forEach {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onBookClicked(it.id) }
                    ) {
                        AsyncImage(
                            model = it.cover,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .width(48.dp)
                                .height(70.dp)
                                .clip(RoundedCornerShape(8.dp))
                        )
                        Column(verticalArrangement = Arrangement.Center) {
                            Text(
                                text = it.name,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Gray55
                            )
                            Text(
                                text = it.author.name,
                                fontSize = 14.sp,
                                color = Gray75
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomChip(text: String, selected: Boolean) {
    val backgroundColor = if (selected) PrimaryColor else Color.White
    val contentColor = if (selected) Color.White else Gray75
    val border = if (!selected) BorderStroke(ChipDefaults.OutlinedBorderSize, GrayE0) else null

    Chip(
        onClick = { /*TODO*/ },
        border = border,
        shape = RoundedCornerShape(16.dp),
        colors = ChipDefaults.chipColors(backgroundColor = backgroundColor, contentColor = contentColor)
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun CardBottomPreview() {
//    CardBottom()
//}
