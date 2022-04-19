package com.example.provamobile.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.provamobile.R
import com.example.provamobile.presentation.theme.Gray55
import com.example.provamobile.presentation.theme.Gray75
import com.example.provamobile.presentation.theme.GrayE0
import com.example.provamobile.presentation.theme.PrimaryColor

@Composable
fun CardBottom() {
    Card(shape = RoundedCornerShape(topStart = 32.dp)) {
        Column(modifier = Modifier.padding(vertical = 32.dp, horizontal = 20.dp)) {
            Section(text = R.string.favorite_authors)

            Spacer(modifier = Modifier.height(20.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                item {
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
                                model = "https://sscdn.co/gcs/studiosol/2022/mobile/avatar.jpg",
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .width(63.dp)
                                    .height(67.dp)
                                    .clip(RoundedCornerShape(8.dp))
                            )
                            Column(verticalArrangement = Arrangement.Center) {
                                Text(
                                    text = "Connie",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Gray55
                                )
                                Text(
                                    text = "6 Livros",
                                    fontSize = 14.sp,
                                    color = Gray75
                                )
                            }
                        }
                    }
                }

                item {
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
                                model = "https://sscdn.co/gcs/studiosol/2022/mobile/avatar.jpg",
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .width(63.dp)
                                    .height(67.dp)
                                    .clip(RoundedCornerShape(8.dp))
                            )
                            Column(verticalArrangement = Arrangement.Center) {
                                Text(
                                    text = "Connie",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Gray55
                                )
                                Text(
                                    text = "6 Livros",
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

            LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                item {
                    CustomChip(text = "Todos", selected = true)
                }
                item {
                    CustomChip(text = "Romance", selected = false)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = "https://sscdn.co/gcs/studiosol/2022/mobile/avatar.jpg",
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(48.dp)
                            .height(70.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )
                    Column(verticalArrangement = Arrangement.Center) {
                        Text(
                            text = "O duque e eu (Os Bridgertons Livro Novo 1)",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Gray55
                        )
                        Text(
                            text = "Julia Quinn",
                            fontSize = 14.sp,
                            color = Gray75
                        )
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = "https://sscdn.co/gcs/studiosol/2022/mobile/avatar.jpg",
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(48.dp)
                            .height(70.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )
                    Column(verticalArrangement = Arrangement.Center) {
                        Text(
                            text = "O duque e eu (Os Bridgertons Livro Novo 1)",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Gray55
                        )
                        Text(
                            text = "Julia Quinn",
                            fontSize = 14.sp,
                            color = Gray75
                        )
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

@Preview(showBackground = true)
@Composable
fun CardBottomPreview() {
    CardBottom()
}
