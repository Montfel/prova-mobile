package com.example.provamobile.presentation.bookdetail

import androidx.lifecycle.ViewModel
import com.apollographql.apollo3.exception.ApolloException
import com.example.provamobile.data.apolloClient
import com.example.rocketreserver.BookDetailQuery
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookDetailViewModel @Inject constructor() : ViewModel() {

    lateinit var bookDetail: BookDetailQuery.Data

    suspend fun setData(id: String? = "1") {
        val response = id?.let {
            try {
                apolloClient.query(BookDetailQuery(id)).execute()
            } catch (e: ApolloException) {
                null
            }
        }
        response?.data?.let {
            this.bookDetail = it
        }
    }
}
