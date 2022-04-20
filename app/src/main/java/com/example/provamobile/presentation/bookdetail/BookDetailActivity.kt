package com.example.provamobile.presentation.bookdetail

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import coil.compose.AsyncImage
import com.apollographql.apollo3.exception.ApolloException
import com.example.provamobile.R
import com.example.provamobile.data.apolloClient
import com.example.provamobile.presentation.components.BottomNavigationCustom
import com.example.provamobile.presentation.theme.Gray55
import com.example.provamobile.presentation.theme.Gray75
import com.example.provamobile.presentation.theme.ProvaMobileTheme
import com.example.rocketreserver.BookDetailQuery

class BookDetailActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = intent.getStringExtra("id")
        lifecycleScope.launchWhenResumed {
            val responseBookDetail = id?.let {
                try {
                    apolloClient.query(BookDetailQuery(id)).execute()
                } catch (e: ApolloException) {
                    Log.d("FavoriteBooks", "Failure", e)
                    null
                }
            }
            val bookDetail = responseBookDetail?.data?.book
            setContent {
                ProvaMobileTheme {
                    val gradientColor = listOf(Color.Black, Color.Transparent)
                    Scaffold(bottomBar = { BottomNavigationCustom() }) {
                        Column(
                            Modifier.verticalScroll(rememberScrollState())
                        ) {
                            Box(Modifier.fillMaxSize()) {
                                AsyncImage(
                                    model = bookDetail?.cover,
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(519.dp)
                                )
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(130.dp)
                                        .background(
                                            brush = Brush.verticalGradient(gradientColor),
                                            alpha = 0.7f
                                        )
                                )
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp)
                                ) {
                                    IconButton(onClick = { /*TODO*/ }) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                                            contentDescription = null,
                                            tint = Color.White
                                        )
                                    }
                                    IconButton(onClick = { /*TODO*/ }) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.ic_baseline_more_vert_24),
                                            contentDescription = null,
                                            tint = Color.White
                                        )
                                    }
                                }
                                Box(modifier = Modifier.padding(top = 260.dp)) {
                                    Card(shape = RoundedCornerShape(topStart = 32.dp)) {
                                        Column(modifier = Modifier.padding(top = 32.dp, start = 20.dp, end = 20.dp)) {
                                            Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                                                Text(
                                                    text = bookDetail?.name ?: "",
                                                    color = Gray55,
                                                    fontWeight = FontWeight.Bold,
                                                    fontSize = 20.sp,
                                                    modifier = Modifier.weight(1f)
                                                )
                                                Image(
                                                    painter = painterResource(
                                                        id = if (bookDetail?.isFavorite
                                                                ?: false
                                                        ) R.drawable.ic_baseline_favorite_24_primary
                                                        else R.drawable.ic_baseline_favorite_border_24
                                                    ),
                                                    contentDescription = null
                                                )
                                            }

                                            Spacer(modifier = Modifier.height(6.dp))

                                            Text(
                                                text = bookDetail?.author?.name ?: "",
                                                color = Gray75,
                                                fontSize = 14.sp
                                            )

                                            Spacer(modifier = Modifier.height(20.dp))

                                            Text(
                                                text = bookDetail?.description ?: "",
                                                color = Gray55,
                                                fontSize = 16.sp
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
