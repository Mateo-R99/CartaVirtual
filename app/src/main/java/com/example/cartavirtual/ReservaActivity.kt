package com.example.cartavirtual

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ReservaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        abrirWhatsApp()
        finish() // Cierra la actividad después de intentar abrir WhatsApp
    }

    private fun abrirWhatsApp() {
        val numeroTelefono = "573001234567" // Reemplaza con el número correcto
        val mensaje = "¡Hola! Quisiera reservar una mesa."
        val url = "https://api.whatsapp.com/send?phone=$numeroTelefono&text=${Uri.encode(mensaje)}"

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "WhatsApp no está instalado", Toast.LENGTH_SHORT).show()
        }
    }
}
