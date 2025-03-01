package com.example.cartavirtual

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cartavirtual.ui.theme.CartaVirtualTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CartaVirtualTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding),
                        onSede1Click = { startActivity(Intent(this, Sede1Activity::class.java)) },
                        onSede2Click = { startActivity(Intent(this, Sede2Activity::class.java)) },
                        onSede3Click = { startActivity(Intent(this, Sede3Activity::class.java)) },
                        onReservaClick = { startActivity(Intent(this, ReservaActivity::class.java)) },
                        onMenuClick = { startActivity(Intent(this, MenuActivity::class.java)) } // Nuevo botón "Ver Menú"
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onSede1Click: () -> Unit,
    onSede2Click: () -> Unit,
    onSede3Click: () -> Unit,
    onReservaClick: () -> Unit,
    onMenuClick: () -> Unit // Nuevo parámetro para el botón "Ver Menú"
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = onSede1Click) { Text("Sede Laureles") }
        Button(onClick = onSede2Click) { Text("Sede Bello") }
        Button(onClick = onSede3Click) { Text("Sede Envigado") }
        Button(onClick = onReservaClick) { Text("Reservar Mesa") }
        Button(onClick = onMenuClick) { Text("Ver Menú") } // Nuevo botón
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    CartaVirtualTheme {
        MainScreen(
            onSede1Click = {},
            onSede2Click = {},
            onSede3Click = {},
            onReservaClick = {},
            onMenuClick = {} // Se agrega para la vista previa
        )
    }
}
