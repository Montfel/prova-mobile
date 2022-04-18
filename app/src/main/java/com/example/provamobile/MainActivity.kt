package com.example.provamobile

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import coil.compose.AsyncImage
import com.example.provamobile.presentation.BottomNavigationCustom
import com.example.provamobile.presentation.Header
import com.example.provamobile.ui.theme.Gray55
import com.example.provamobile.ui.theme.Gray75
import com.example.provamobile.ui.theme.GrayE0
import com.example.provamobile.ui.theme.GrayF2
import com.example.provamobile.ui.theme.PrimaryColor
import com.example.provamobile.ui.theme.ProvaMobileTheme
import com.example.rocketreserver.LaunchListQuery

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val response = lifecycleScope.launchWhenResumed {
            apolloClient.query(LaunchListQuery()).execute().data
        }
        setContent {
            ProvaMobileTheme {
                Scaffold(
                    topBar = { Header(response) },
                    bottomBar = { BottomNavigationCustom() },
                    backgroundColor = GrayF2,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column() {
                        Section(text = R.string.favorite_books)

                        Spacer(modifier = Modifier.height(20.dp))

                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(20.dp),
                            modifier = Modifier.padding(horizontal = 20.dp)
                        ) {
                            item {
                                Column(
                                    modifier = Modifier
                                        .clickable { }
                                        .width(140.dp)
                                ) {
                                    AsyncImage(
                                        model = "https://sscdn.co/gcs/studiosol/2022/mobile/avatar.jpg",
                                        contentDescription = null,
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
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Card(shape = RoundedCornerShape(topStart = 32.dp)) {
                            Column {
                                Section(text = R.string.favorite_authors)

                                Spacer(modifier = Modifier.height(20.dp))

                                LazyRow(
                                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                                    modifier = Modifier.padding(horizontal = 20.dp)
                                ) {
                                    item {
                                        Card(
                                            shape = RoundedCornerShape(8.dp),
                                            border = BorderStroke(width = 1.dp, color = GrayE0),
                                            modifier = Modifier
                                                .width(250.dp)
                                                .height(70.dp)
                                        ) {
                                            Row(
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.spacedBy(20.dp)
                                            ) {
                                                AsyncImage(
                                                    model = "https://sscdn.co/gcs/studiosol/2022/mobile/avatar.jpg",
                                                    contentDescription = null,
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

                                Section(text = R.string.library, showAll = false)

                                LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                    item {
                                        CustomChip(text = "Todos", selected = true)
                                    }
                                    item {
                                        CustomChip(text = "Romance", selected = false)
                                    }
                                }

                                LazyColumn {
                                    item {
                                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                            AsyncImage(
                                                model = "https://sscdn.co/gcs/studiosol/2022/mobile/avatar.jpg",
                                                contentDescription = null,
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

@Composable
fun Section(@StringRes text: Int, showAll: Boolean = true) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp, start = 20.dp, end = 20.dp)
    ) {
        Text(
            text = stringResource(id = text),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Gray55
        )
        if (showAll) {
            Text(
                text = stringResource(id = R.string.show_all),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProvaMobileTheme {
    }
}
