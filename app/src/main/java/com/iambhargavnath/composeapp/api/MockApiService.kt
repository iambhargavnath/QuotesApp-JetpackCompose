package com.iambhargavnath.composeapp.api

import com.iambhargavnath.composeapp.model.Quote

class MockApiService : ApiService {
    override suspend fun getItems(): List<Quote> {
        return listOf(
            Quote(quote = "The only way to do great work is to love what you do.", author = "Steve Jobs", language = "English", id = 1),
            Quote(quote = "Success is not final, failure is not fatal: It is the courage to continue that counts.", author =  "Winston Churchill", language = "English", id = 2),
        )
    }
}
