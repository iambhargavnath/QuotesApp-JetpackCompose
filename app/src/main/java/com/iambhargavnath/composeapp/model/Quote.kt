package com.iambhargavnath.composeapp.model

data class Quote(
    val author: String,
    val createdAt: String="",
    val id: Int,
    val language: String,
    val quote: String,
    val updatedAt: String=""
)