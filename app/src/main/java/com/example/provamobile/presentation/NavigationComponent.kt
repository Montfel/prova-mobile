package com.example.provamobile.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.provamobile.presentation.bookdetail.BookDetail
import com.example.provamobile.presentation.bookdetail.BookDetailViewModel
import com.example.provamobile.presentation.home.Home
import com.example.provamobile.presentation.home.HomeViewModel
import kotlinx.coroutines.runBlocking

@Composable
fun NavigationComponent(

) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            val homeViewModel = hiltViewModel<HomeViewModel>()
            Home(
                navController = navController,
                viewModel = homeViewModel
            )
        }
        composable("bookDetail/{id}") {
            val id = navController.previousBackStackEntry?.arguments?.getString("id")
            val bookDetailViewModel = hiltViewModel<BookDetailViewModel>()
            runBlocking {
                bookDetailViewModel.setData(id = id)
            }
            BookDetail(
                navController = navController,
                viewModel = bookDetailViewModel
            )
        }
    }
}

