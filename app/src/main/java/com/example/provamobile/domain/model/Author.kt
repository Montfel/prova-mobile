package com.example.provamobile.domain.model

data class Author(
    val id: Long,
    val name: String,
    val picture: String,
    val booksCount: Int,
    val isFavorite: Boolean,
    val books: List<Book>
)
