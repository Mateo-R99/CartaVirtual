package com.example.cartavirtual

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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

class Sede1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CartaVirtualTheme {
                SedeScreen(
                    nombreSede = "Sede Laureles",
                    direccion = "Circular 4 # 71-92, Laureles, Medellín",
                    telefono = "(330) 788-6595",
                    horario = "Martes a Domingo, 9AM - 10PM",
                )
            }
        }
    }
}


