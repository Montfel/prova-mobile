package com.example.provamobile.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.provamobile.presentation.components.BottomNavigationCustom
import com.example.provamobile.presentation.theme.GrayF2
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun Home(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.getHomeData()
    }

    Scaffold(
        bottomBar = { BottomNavigationCustom() },
        backgroundColor = GrayF2,
    ) { paddingValue ->
        Column(
            verticalArrangement = Arrangement.spacedBy(32.dp),
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(paddingValue)
        ) {
            Header(uiState.homeData?.userPicture)
            FavoriteBooks(
                favoriteBooks = uiState.homeData?.favoriteBooks,
                onFavoriteBookClicked = { navController.navigate("bookDetail/$it") }
            )
            Card(shape = RoundedCornerShape(topStart = 30.dp)) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(32.dp),
                    modifier = Modifier.padding(vertical = 32.dp)
                ) {
                    FavoriteAuthors(favoriteAuthors = uiState.homeData?.favoriteAuthors)
                    Library(
                        allBooks = uiState.homeData?.allBooks,
                        onBookClicked = { navController.navigate("bookDetail/$it") }
                    )
                }
            }
        }
    }
}
