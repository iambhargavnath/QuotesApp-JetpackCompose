package com.iambhargavnath.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.iambhargavnath.composeapp.api.RetrofitInstance
import com.iambhargavnath.composeapp.repository.ItemRepository
import com.iambhargavnath.composeapp.ui.screen.ItemListScreen
import com.iambhargavnath.composeapp.ui.theme.ComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val apiService = RetrofitInstance.apiService
            val repository = remember { ItemRepository(apiService) }
            val viewModel = remember { ItemViewModel(repository) }

            ComposeAppTheme {
                Surface {
                    ItemListScreen(viewModel)
                }
            }
        }
    }
}