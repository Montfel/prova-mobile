package com.example.provamobile.presentation.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.provamobile.R
import com.example.provamobile.presentation.components.Section
import com.example.provamobile.presentation.theme.Gray55
import com.example.provamobile.presentation.theme.Gray75
import com.example.provamobile.presentation.theme.GrayE0
import com.example.rocketreserver.HomeQuery

@Composable
fun FavoriteAuthors(favoriteAuthors: List<HomeQuery.FavoriteAuthor>?) {
    val current = LocalContext.current
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Section(text = R.string.favorite_authors)

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
    }
}
