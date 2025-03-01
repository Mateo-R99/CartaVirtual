package com.example.cartavirtual

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cartavirtual.ui.theme.CartaVirtualTheme

class Sede2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CartaVirtualTheme {
                SedeScreen(
                    nombreSede = "Sede Bello",
                    direccion = "Carrera 50 #35-96, Madera, Bello",
                    telefono = "(321) 659-3210",
                    horario = "Lunes a Sábado: 9:00 AM - 11:30 PM"
                )
            }
        }
    }
}
