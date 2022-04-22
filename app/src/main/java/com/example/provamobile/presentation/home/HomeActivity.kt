package com.example.provamobile.presentation.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.apollographql.apollo3.exception.ApolloException
import com.example.provamobile.data.apolloClient
import com.example.provamobile.presentation.bookdetail.BookDetailActivity
import com.example.provamobile.presentation.components.BottomNavigationCustom
import com.example.provamobile.presentation.theme.GrayF2
import com.example.provamobile.presentation.theme.ProvaMobileTheme
import com.example.rocketreserver.AllBooksQuery
import com.example.rocketreserver.CategoriesQuery
import com.example.rocketreserver.FavoriteAuthorsQuery
import com.example.rocketreserver.FavoriteBooksQuery
import com.example.rocketreserver.UserPictureQuery
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launchWhenResumed {
            val responseUser = try {
                apolloClient.query(UserPictureQuery()).execute()
            } catch (e: ApolloException) {
                null
            }
            val responseFavoriteBooks = try {
                apolloClient.query(FavoriteBooksQuery()).execute()
            } catch (e: ApolloException) {
                null
            }
            val responseFavoriteAuthors = try {
                apolloClient.query(FavoriteAuthorsQuery()).execute()
            } catch (e: ApolloException) {
                null
            }
            val responseCategories = try {
                apolloClient.query(CategoriesQuery()).execute()
            } catch (e: ApolloException) {
                null
            }
            val responseAllBooks = try {
                apolloClient.query(AllBooksQuery()).execute()
            } catch (e: ApolloException) {
                null
            }
            val pic = responseUser?.data?.userPicture
            val favoriteBooks = responseFavoriteBooks?.data?.favoriteBooks
            val favoriteAuthors = responseFavoriteAuthors?.data?.favoriteAuthors
            val categories = responseCategories?.data?.allBooks
            val allBooks = responseAllBooks?.data?.allBooks
            val intent = Intent(this@HomeActivity, BookDetailActivity::class.java)
            setContent {
                ProvaMobileTheme {
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
                            Header(pic)
                            FavoriteBooks(
                                favoriteBooks = favoriteBooks,
                                onFavoriteBookClicked = {
                                    intent.putExtra("id", it)
                                    startActivity(intent)
                                }
                            )
                            Card(shape = RoundedCornerShape(topStart = 30.dp)) {
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(32.dp),
                                    modifier = Modifier.padding(vertical = 32.dp)
                                ) {
                                    FavoriteAuthors(favoriteAuthors = favoriteAuthors)
                                    Library(
                                        categories = categories,
                                        allBooks = allBooks,
                                        onBookClicked = {
                                            intent.putExtra("id", it)
                                            startActivity(intent)
                                        }
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProvaMobileTheme {
    }
}
