package com.iambhargavnath.composeapp.api

import com.iambhargavnath.composeapp.model.Quote
import retrofit2.http.GET

interface ApiService {
    @GET("quotes")
    suspend fun getItems(): List<Quote>
}