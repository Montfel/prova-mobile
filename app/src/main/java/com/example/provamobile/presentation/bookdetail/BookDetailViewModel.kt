package com.example.provamobile.presentation.bookdetail

import androidx.lifecycle.ViewModel
import com.apollographql.apollo3.exception.ApolloException
import com.example.provamobile.data.apolloClient
import com.example.rocketreserver.BookDetailQuery
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext
import javax.inject.Inject

data class BookDetailUiState(
    val bookDetailData: BookDetailQuery.Data? = null
)

@HiltViewModel
class BookDetailViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(BookDetailUiState())
    val uiState: StateFlow<BookDetailUiState> = _uiState

    suspend fun getBookDetailData(id: String) {
        val response = withContext(Dispatchers.IO) {
            try {
                apolloClient.query(BookDetailQuery(id)).execute()
            } catch (e: ApolloException) {
                throw Exception()
            }
        }
        _uiState.update {
            it.copy(bookDetailData = response.data)
        }
    }
}
