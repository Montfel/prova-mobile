package com.example.provamobile.presentation.bookdetail

import androidx.lifecycle.ViewModel
import com.apollographql.apollo3.exception.ApolloException
import com.example.provamobile.data.apolloClient
import com.example.rocketreserver.BookDetailQuery
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookDetailViewModel @Inject constructor() : ViewModel() {

    var bookDetail: BookDetailQuery.Data? = null

    suspend fun getBookDetailData(id: String?) {
        val response = id?.let {
            try {
                apolloClient.query(BookDetailQuery(it)).execute()
            } catch (e: ApolloException) {
                throw Exception()
            }
        }
        response?.data?.let {
            this.bookDetail = it
        }
    }
}
