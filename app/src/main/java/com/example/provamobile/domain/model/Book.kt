package com.example.provamobile.domain.model

data class Book(
    val id: Long,
    val name: String,
    val author: Author,
    val cover: String,
    val description: String,
    val isFavorite: Boolean,
    val category: String
)
