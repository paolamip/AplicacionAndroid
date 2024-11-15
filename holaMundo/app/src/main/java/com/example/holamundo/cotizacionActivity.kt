package com.example.holamundo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CotizacionActivity : AppCompatActivity() {
    private lateinit var txtCliente: EditText
    private lateinit var btnIngresar: Button
    private lateinit var btnRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cotizacion)
        iniciarComponente()
        eventosClic()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun iniciarComponente() {
        txtCliente = findViewById(R.id.txtCliente)
        btnRegresar = findViewById(R.id.btnRegresar)
        btnIngresar = findViewById(R.id.btnIngresar)
    }

    private fun eventosClic() {
        btnIngresar.setOnClickListener {
            if (txtCliente.text.toString().isEmpty()) {
                Toast.makeText(this, "Falto capturar el nombre del cliente", Toast.LENGTH_SHORT).show()
                txtCliente.requestFocus()
            } else {
                val intent = Intent(this, CotizacionActivity::class.java)
                intent.putExtra("Cliente", txtCliente.text.toString())
                startActivity(intent)
            }
        }

        btnRegresar.setOnClickListener {
            finish()
        }
    }
}


}
}