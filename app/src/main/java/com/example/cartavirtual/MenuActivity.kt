package com.example.cartavirtual

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MenuScreen(
                menu = listOf(
                    Plato("Hamburguesa Clásica", "Carne 100% de res con queso y papas fritas", "$25,000", R.drawable.hamburguesa),
                    Plato("Pizza Pepperoni", "Queso mozzarella y pepperoni fresco", "$30,000", R.drawable.pizza),
                    Plato("Ensalada César", "Lechuga, pollo a la plancha y aderezo césar", "$18,000", R.drawable.ensalada),
                    Plato("Lasaña de Carne", "Capas de pasta, carne molida y queso parmesano", "$28,000", R.drawable.lasana),
                    Plato("Sushi Variado", "Rolls de salmón, atún y aguacate", "$35,000", R.drawable.sushi)
                )
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class) // Indica que estás usando una API experimental
@Composable
fun MenuScreen(menu: List<Plato>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Menú del Restaurante") }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            items(menu) { plato ->
                MenuItem(plato)
            }
        }
    }
}

@Composable
fun MenuItem(plato: Plato) {
    Row(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = plato.imagen),
            contentDescription = plato.nombre,
            modifier = Modifier
                .size(80.dp)
                .padding(end = 16.dp)
        )
        Column {
            Text(text = plato.nombre, style = MaterialTheme.typography.titleMedium)
            Text(text = plato.descripcion, style = MaterialTheme.typography.bodyMedium)
            Text(text = plato.precio, style = MaterialTheme.typography.bodyLarge)
        }
    }
}

data class Plato(
    val nombre: String,
    val descripcion: String,
    val precio: String,
    val imagen: Int
)
