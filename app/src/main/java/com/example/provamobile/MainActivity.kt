package com.example.provamobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.provamobile.presentation.BottomNavigationCustom
import com.example.provamobile.presentation.Header
import com.example.provamobile.ui.theme.Gray55
import com.example.provamobile.ui.theme.Gray75
import com.example.provamobile.ui.theme.GrayE0
import com.example.provamobile.ui.theme.GrayF2
import com.example.provamobile.ui.theme.PrimaryColor
import com.example.provamobile.ui.theme.ProvaMobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProvaMobileTheme {
                Scaffold(
                    topBar = { Header() },
                    bottomBar = { BottomNavigationCustom() },
                    backgroundColor = GrayF2
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Section(text = R.string.favorite_books)

                        Spacer(modifier = Modifier.height(20.dp))

                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(20.dp),
                            modifier = Modifier.padding(horizontal = 20.dp)
                        ) {
                            item() {
                                Column(
                                    modifier = Modifier
                                        .clickable { }
                                        .width(140.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.img),
                                        contentDescription = null
                                    )
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Text(
                                        text = "O duque e eu (Os Bridgertons – Livro 1)",
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
                                Column() {
                                    Image(
                                        painter = painterResource(id = R.drawable.img),
                                        contentDescription = null
                                    )
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Text(
                                        text = "O duque",
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
                                Column() {
                                    Image(painter = painterResource(id = R.drawable.img), contentDescription = null)
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Text(
                                        text = "O duque",
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
                                Column() {
                                    Image(painter = painterResource(id = R.drawable.img), contentDescription = null)
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Text(
                                        text = "O duque",
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
                                Column() {
                                    Image(painter = painterResource(id = R.drawable.img), contentDescription = null)
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Text(
                                        text = "O duque",
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

                        Surface(
                            elevation = 1.dp,
                            shape = RoundedCornerShape(topStart = 32.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column() {
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
                                            modifier = Modifier.width(250.dp)
                                        ) {
                                            Row(
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.spacedBy(20.dp)
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.img_1),
                                                    contentDescription = null
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
                                            modifier = Modifier.width(250.dp)
                                        ) {
                                            Row(
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.spacedBy(20.dp)
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.img_1),
                                                    contentDescription = null
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

                            }

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Section(@StringRes text: Int) {
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
        Text(
            text = stringResource(id = R.string.show_all),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = PrimaryColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProvaMobileTheme {
    }
}
