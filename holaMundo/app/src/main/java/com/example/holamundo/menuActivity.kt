package com.example.holamundo

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class menuActivity : AppCompatActivity() {
    private lateinit var crvHola : CardView
    private lateinit var crvImc : CardView
    private lateinit var crvConvertidor : CardView
    private lateinit var crvMoneda : CardView
    private lateinit var crvCotizacion : CardView
    private lateinit var crvSalir : CardView
    override fun onCreate(savedInstanceState: Bundle?) { paola meave *
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun iniciarComponente(){
        crvHola = findViewById(R.id.crvHola) as CardView
        crvImc = findViewById(R.id.crvImc) as CardView
        crvConvertidor = findViewById(R.id.crvConvertidor) as CardView
        crvMoneda = findViewById(R.id.crvMoneda) as CardView
        crvCotizacion = findViewById(R.id.crvCotizacion) as CardView
        crvSalir = findViewById(R.id.crvSalir)

    }

    fun eventosClic(){
        crvHola.setOnClickListener(View.OnClickListener {
            val intent = Intent (packageContext: this, MainActivity::class.java)
            startActivity()
        })
    }
}