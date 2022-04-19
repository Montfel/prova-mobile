package com.example.provamobile.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.provamobile.R
import com.example.provamobile.presentation.theme.Gray55
import com.example.provamobile.presentation.theme.Gray75

@Composable
fun FavoriteBooks() {
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Section(text = R.string.favorite_books)

        LazyRow() {
            item {
                Spacer(modifier = Modifier.width(20.dp))
            }
            item {
                Column(
                    modifier = Modifier
                        .clickable { }
                        .width(136.dp)
                ) {
                    AsyncImage(
                        model = "https://sscdn.co/gcs/studiosol/2022/mobile/avatar.jpg",
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(136.dp)
                            .height(198.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "O duque e eu (Os Bridgertons Livro Novo 1)",
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Gray55
                    )
                    Text(
                        text = "Julia",
                        fontSize = 14.sp,
                        color = Gray75
                    )
                }
            }
            item {
                Column(
                    modifier = Modifier
                        .clickable { }
                        .width(136.dp)
                ) {
                    AsyncImage(
                        model = "https://sscdn.co/gcs/studiosol/2022/mobile/avatar.jpg",
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(136.dp)
                            .height(198.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "O duque e eu (Os Bridgertons Livro Novo 1)",
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Gray55
                    )
                    Text(
                        text = "Julia",
                        fontSize = 14.sp,
                        color = Gray75
                    )
                }
            }
            item {
                Column(
                    modifier = Modifier
                        .clickable { }
                        .width(136.dp)
                ) {
                    AsyncImage(
                        model = "https://sscdn.co/gcs/studiosol/2022/mobile/avatar.jpg",
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(136.dp)
                            .height(198.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "O duque e eu (Os Bridgertons Livro Novo 1)",
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Gray55
                    )
                    Text(
                        text = "Julia",
                        fontSize = 14.sp,
                        color = Gray75
                    )
                }
            }
            item {
                Column(
                    modifier = Modifier
                        .clickable { }
                        .width(136.dp)
                ) {
                    AsyncImage(
                        model = "https://sscdn.co/gcs/studiosol/2022/mobile/avatar.jpg",
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(136.dp)
                            .height(198.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "O duque e eu (Os Bridgertons Livro Novo 1)",
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Gray55
                    )
                    Text(
                        text = "Julia",
                        fontSize = 14.sp,
                        color = Gray75
                    )
                }
            }
            item {
                Spacer(modifier = Modifier.width(20.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MiddlePreview() {
    FavoriteBooks()
}
