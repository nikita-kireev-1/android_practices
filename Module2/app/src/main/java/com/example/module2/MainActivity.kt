package com.example.module2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.module2.ui.theme.Module2Theme
import kotlin.random.Random

data class Product(
    val id: Int,
    val name: String,
    val price: Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Module2Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    ShoppingCartScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ShoppingCartScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    var products by rememberSaveable {
        mutableStateOf(
            listOf(
                Product(0, "Товар #1", 100),
                Product(1, "Товар #2", 150),
                Product(2, "Товар #3", 56)
            )
        )
    }

    val totalSum = products.sumOf { it.price }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        for (product in products) {
            Text(
                text = "${product.name} — ${product.price} рублей"
            )
        }

        Text(
            text = "Товаров на сумму: $totalSum рублей"
        )

        AddProductSection(
            onAdd = {
                val newProduct = Product(
                    id = products.size,
                    name = "Товар #${products.size + 1}",
                    price = Random.nextInt(1, 100)
                )

                val updatedProducts = products + newProduct
                products = updatedProducts

                if (updatedProducts.sumOf { it.price } > 500) {
                    Toast.makeText(
                        context,
                        "Доставка бесплатная!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        )

        RemoveProductSection(
            hasProducts = products.isNotEmpty(),
            onRemove = {
                products = products.dropLast(1)
            }
        )
    }
}

@Composable
fun AddProductSection(onAdd: () -> Unit) {
    Button(onClick = onAdd) {
        Text(text = "Добавить товар")
    }
}

@Composable
fun RemoveProductSection(
    hasProducts: Boolean,
    onRemove: () -> Unit
) {
    if (hasProducts) {
        Button(onClick = onRemove) {
            Text(text = "Удалить товар")
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun ShoppingCartPreview() {
    Module2Theme {
        Scaffold { innerPadding ->
            ShoppingCartScreen(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}