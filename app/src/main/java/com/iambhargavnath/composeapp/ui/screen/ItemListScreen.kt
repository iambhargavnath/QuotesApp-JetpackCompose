package com.iambhargavnath.composeapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iambhargavnath.composeapp.ItemViewModel
import com.iambhargavnath.composeapp.api.MockApiService
import com.iambhargavnath.composeapp.api.RetrofitInstance
import com.iambhargavnath.composeapp.model.Quote
import com.iambhargavnath.composeapp.repository.ItemRepository


@Composable
fun ItemListScreen(viewModel: ItemViewModel) {
    val items = viewModel.items
    val isLoading = viewModel.isLoading.value
    val errorMessage = viewModel.errorMessage.value

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        if (isLoading) {
            CircularProgressIndicator()
        } else if (errorMessage.isNotEmpty()) {
            Text("Error: $errorMessage")
        } else {
            LazyColumn {
                items(items.size) { index ->
                    val item = items[index]
                    ItemRow(item)
                }
            }
        }
    }
}

@Composable
fun ItemRow(item: Quote) {
    Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = item.quote, style = MaterialTheme.typography.headlineMedium)
            Text(text = "~ ${item.author}")
        }
    }
}

class FakeItemRepository : ItemRepository(MockApiService())

@Preview(showBackground = true)
@Composable
fun ItemListScreenPreview() {
    val viewModel = ItemViewModel(FakeItemRepository())
    ItemListScreen(viewModel = viewModel)
}