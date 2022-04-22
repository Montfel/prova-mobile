package com.example.provamobile.presentation.home

import androidx.lifecycle.ViewModel
import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.exception.ApolloException
import com.example.provamobile.data.apolloClient
import com.example.rocketreserver.UserPictureQuery
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    suspend fun setData() : String? {
        val responseUser = try {
            apolloClient.query(UserPictureQuery()).execute()
        } catch (e: ApolloException) {
            null
        }
        return responseUser?.data?.userPicture
    }
//    val responseFavoriteBooks = try {
//        apolloClient.query(FavoriteBooksQuery()).execute()
//    } catch (e: ApolloException) {
//        null
//    }
//    val responseFavoriteAuthors = try {
//        apolloClient.query(FavoriteAuthorsQuery()).execute()
//    } catch (e: ApolloException) {
//        null
//    }
//    val responseCategories = try {
//        apolloClient.query(CategoriesQuery()).execute()
//    } catch (e: ApolloException) {
//        null
//    }
//    val responseAllBooks = try {
//        apolloClient.query(AllBooksQuery()).execute()
//    } catch (e: ApolloException) {
//        null
//    }
//    val pic = responseUser?.data?.userPicture
//    val favoriteBooks = responseFavoriteBooks?.data?.favoriteBooks
//    val favoriteAuthors = responseFavoriteAuthors?.data?.favoriteAuthors
//    val categories = responseCategories?.data?.allBooks
//    val allBooks = responseAllBooks?.data?.allBooks
}
