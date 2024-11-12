package com.iambhargavnath.composeapp.repository

import com.iambhargavnath.composeapp.api.ApiService
import com.iambhargavnath.composeapp.model.Quote

open class ItemRepository(private val apiService: ApiService) {
    suspend fun fetchItems(): List<Quote> {
        return apiService.getItems()
    }
}