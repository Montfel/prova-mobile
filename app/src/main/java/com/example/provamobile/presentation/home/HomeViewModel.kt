package com.example.provamobile.presentation.home

import androidx.lifecycle.ViewModel
import com.apollographql.apollo3.exception.ApolloException
import com.example.provamobile.data.apolloClient
import com.example.rocketreserver.HomeQuery
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    var homeData: HomeQuery.Data? = null

    suspend fun getHomeData() {
        val response = try {
            apolloClient.query(HomeQuery()).execute()
        } catch (e: ApolloException) {
            throw Exception()
        }
        this.homeData = response.data
    }
}
