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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.provamobile.presentation.components.BottomNavigationCustom
import com.example.provamobile.presentation.theme.GrayF2

@Composable
fun Home(
    navController: NavController,
    viewModel: HomeViewModel
) {
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
            Header(viewModel.homeData?.userPicture)
            FavoriteBooks(
                favoriteBooks = viewModel.homeData?.favoriteBooks,
                onFavoriteBookClicked = { navController.navigate("bookDetail/$it") }
            )
            Card(shape = RoundedCornerShape(topStart = 30.dp)) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(32.dp),
                    modifier = Modifier.padding(vertical = 32.dp)
                ) {
                    FavoriteAuthors(favoriteAuthors = viewModel.homeData?.favoriteAuthors)
                    Library(
                        allBooks = viewModel.homeData?.allBooks,
                        onBookClicked = { navController.navigate("bookDetail/$it") }
                    )
                }
            }
        }
    }
}
