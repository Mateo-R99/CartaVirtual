package com.example.cartavirtual

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cartavirtual.ui.theme.CartaVirtualTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SedeScreen(nombreSede: String, direccion: String, telefono: String, horario: String) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = nombreSede, fontWeight = FontWeight.Bold) }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Dirección: $direccion", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Teléfono: $telefono", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Horario: $horario", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                val gmmIntentUri = Uri.parse("geo:0,0?q=${Uri.encode(direccion)}")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                context.startActivity(mapIntent)
            }) {
                Text("Ver en Google Maps")
            }
        }
    }
}

class Sede3Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CartaVirtualTheme {
                SedeScreen(
                    nombreSede = "Sede Envigado",
                    direccion = "Carrera 35 # 38 A Sur 12, Envigado",
                    telefono = "(315) 129-9865",
                    horario = "Lunes a Domingo: 1:00 PM - 11:00 PM"
                )
            }
        }
    }
}
