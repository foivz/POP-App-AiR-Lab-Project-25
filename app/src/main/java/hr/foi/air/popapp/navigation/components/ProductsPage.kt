package hr.foi.air.popapp.navigation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import hr.foi.air.popapp.ui.components.ProductCard
import hr.foi.air.popapp.viewmodels.ProductsViewModel
import hr.foi.air.ws.models.Product

@Composable
fun ProductsPage(viewModel: ProductsViewModel = viewModel()) {
    val products by viewModel.products.observeAsState()

    if (products?.isEmpty() == true) {
        CircularProgressIndicator(
            modifier = Modifier.fillMaxSize()
        )
    } else {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            (products as List<Product>).withIndex().map { (index, product) ->
                ProductCard(product = product)
            }
        }
    }
}