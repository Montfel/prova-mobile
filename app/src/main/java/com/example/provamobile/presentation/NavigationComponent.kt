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

@Composable
fun NavigationComponent() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            Home(navController = navController)
        }
        composable("bookDetail/{id}") {
            BookDetail(
                id = it.arguments?.getString("id")!!,
                navController = navController
            )
        }
    }
}
