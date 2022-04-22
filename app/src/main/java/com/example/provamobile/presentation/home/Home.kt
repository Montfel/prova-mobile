package com.example.provamobile.presentation.home

import androidx.compose.foundation.clickable
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
                .clickable { navController.navigate("bookDetail/1") }
        ) {
            Header("")
            FavoriteBooks(
                favoriteBooks = listOf(),
                onFavoriteBookClicked = {
                    navController.navigate("bookDetail/{1}")
                }
            )
            Card(shape = RoundedCornerShape(topStart = 30.dp)) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(32.dp),
                    modifier = Modifier.padding(vertical = 32.dp)
                ) {
                    FavoriteAuthors(favoriteAuthors = listOf())
                    Library(
                        categories = listOf(),
                        allBooks = listOf(),
                        onBookClicked = {
                            navController.navigate("bookDetail/{1}")
                        }
                    )
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun FavoriteAuthorsPreview() {
//    FavoriteAuthors()
//}
