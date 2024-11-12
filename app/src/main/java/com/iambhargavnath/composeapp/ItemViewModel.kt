package com.iambhargavnath.composeapp

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iambhargavnath.composeapp.model.Quote
import com.iambhargavnath.composeapp.repository.ItemRepository
import kotlinx.coroutines.launch

open class ItemViewModel(private val repository: ItemRepository) : ViewModel() {
    var items = mutableStateListOf<Quote>()
    var isLoading = mutableStateOf(true)
    var errorMessage = mutableStateOf("")

    init {
        getItems()
    }

    private fun getItems() {
        viewModelScope.launch {
            try {
                items.addAll(repository.fetchItems())
            } catch (e: Exception) {
                errorMessage.value = e.message ?: "Unknown Error"
            } finally {
                isLoading.value = false
            }
        }
    }
}