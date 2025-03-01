package com.example.cartavirtual

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Retrasa la transición a MainActivity por 3 segundos
        Handler(Looper.getMainLooper()).postDelayed({
            startMainActivity()
        }, 3000) // 3000 ms = 3 segundos
    }

    // Método para iniciar MainActivity y finalizar SplashActivity
    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
