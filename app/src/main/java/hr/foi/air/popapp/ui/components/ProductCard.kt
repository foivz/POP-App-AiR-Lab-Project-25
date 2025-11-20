package hr.foi.air.popapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import hr.foi.air.popapp.ui.theme.Shapes
import hr.foi.air.popapp.ui.theme.Typography
import hr.foi.air.ws.models.Product

@Composable
fun ProductCard(product: Product) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        shape = Shapes.medium
    ) {
        Column {
            Text(
                text = "Product ID: ${product.id}",
                style = Typography.titleSmall,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(product.description!!)
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text("Price: $${product.price?.div(100)}")
                Text("Quantity: ${product.quantity}")
            }
        }
    }
}








