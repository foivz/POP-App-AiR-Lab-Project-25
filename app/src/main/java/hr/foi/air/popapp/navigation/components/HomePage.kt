package hr.foi.air.popapp.navigation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import hr.foi.air.popapp.ui.components.MenuItem
import java.util.Locale

@Composable
fun HomePage(
    onMenuOptionSelected: (option: String) -> Unit
) {
    val menuItems = listOf(
        "Products" to Icons.Filled.ShoppingCart,
        "Balance" to Icons.Filled.Star,
        "Invoices" to Icons.AutoMirrored.Filled.List
    )


    Column(
        modifier = Modifier.background(MaterialTheme.colorScheme.background)
    ) {
        Text("Welcome")
        LazyColumn {
            items(menuItems) { (text, icon) ->
                MenuItem(text, icon) {
                    onMenuOptionSelected(text.lowercase(Locale.getDefault()))
                }
            }
        }
    }
}