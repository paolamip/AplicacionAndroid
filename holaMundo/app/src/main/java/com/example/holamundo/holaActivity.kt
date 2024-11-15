package com.example.holamundo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class menuActivity : AppCompatActivity() {
    private lateinit var lblSaludo : TextView
    private lateinit var txtNombre : EditText
    private lateinit var btnSaludar : Button
    private lateinit var btnLimpiar : Button
    private lateinit var btnCerrar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu2)

        IniciarComponentes()
        eventosBottones()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun iniciarComponente() {
        lblSaludo = findViewById(R.id.lblSaludar) as TextView
        txtNombre = findViewById(R.id.txtNombre) as EditText
        btnSaludar = findViewById(R.id.btnSaludo)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnCerrar = findViewById(R.id.btnCerrar)
    }
    fun eventosClic(){
        btnSaludar.setOnClickListener(View.OnClickListener {
            var strNombre : String = "";
            if (txtNombre.text.toString().contentEquals(charSequence = "")){
                Toast.makeText(applicationContext,text: "Falto capturar el Nombre",Toast.LENGTH_SHORT).show()
            }
           else{
               strNombre = "Hola" + txtNombre.text.toString() + "Como estas ?"
                lblSaludo.text = strNombre
            }
        })
        btnLimpiar.setOnClickListener(View.OnClickListener {
            txtNombre.setText("")
            lblSaludo.setText("")
        })
        btnCerrar.setOnClickListener(View.OnClickListener {
            finish()
        })
        crvHola.setOnClickListener(View.OnClickListener {
            val intent = Intent (packageContext: this, MainActivity::class.java)
            startActivity()
        })
    }

}