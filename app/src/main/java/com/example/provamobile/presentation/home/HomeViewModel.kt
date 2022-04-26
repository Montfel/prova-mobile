package com.example.provamobile.presentation.home

import androidx.lifecycle.ViewModel
import com.apollographql.apollo3.exception.ApolloException
import com.example.provamobile.data.apolloClient
import com.example.rocketreserver.HomeQuery
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext
import javax.inject.Inject

data class HomeUiState(
    val homeData: HomeQuery.Data? = null
)

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState

    suspend fun getHomeData() {
        val response = withContext(Dispatchers.IO) {
            try {
                apolloClient.query(HomeQuery()).execute()
            } catch (e: ApolloException) {
                throw Exception()
            }
        }
        _uiState.update {
            it.copy(homeData = response.data)
        }
    }
}
