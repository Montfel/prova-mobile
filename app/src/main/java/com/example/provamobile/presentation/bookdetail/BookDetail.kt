package com.example.provamobile.presentation.bookdetail

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.provamobile.R
import com.example.provamobile.presentation.components.BottomNavigationCustom
import com.example.provamobile.presentation.theme.Gray55
import com.example.provamobile.presentation.theme.Gray75

@Composable
fun BookDetail(
    id: String,
    navController: NavController,
    viewModel: BookDetailViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = Unit) {
        viewModel.getBookDetailData(id)
    }

    val uiState by viewModel.uiState.collectAsState()

    val gradientColor = listOf(Color.Black, Color.Transparent)
    Scaffold(bottomBar = { BottomNavigationCustom() }) { paddingValue ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(paddingValues = paddingValue)
        ) {
            Box(Modifier.fillMaxSize()) {
                AsyncImage(
                    model = uiState.bookDetailData?.book?.cover,
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
                    IconButton(onClick = { navController.popBackStack() }) {
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
                                    text = uiState.bookDetailData?.book?.name ?: "",
                                    color = Gray55,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp,
                                    modifier = Modifier.weight(1f)
                                )
                                Image(
                                    painter = painterResource(
                                        id = if (uiState.bookDetailData?.book?.isFavorite ?: false)
                                            R.drawable.ic_baseline_favorite_24_primary
                                        else R.drawable.ic_baseline_favorite_border_24
                                    ),
                                    contentDescription = null
                                )
                            }

                            Spacer(modifier = Modifier.height(6.dp))

                            Text(
                                text = uiState.bookDetailData?.book?.author?.name ?: "",
                                color = Gray75,
                                fontSize = 14.sp
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Text(
                                text = uiState.bookDetailData?.book?.description ?: "",
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
