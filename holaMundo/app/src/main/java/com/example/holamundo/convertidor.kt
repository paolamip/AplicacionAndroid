package com.example.holamundo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class convertidor : AppCompatActivity() {
    private lateinit var txtCantidad : EditText
    private lateinit var txtResultado : TextView
    private lateinit var rdbCel : RadioButton
    private lateinit var rdbFar : RadioButton

    private lateinit var btnCalcular : Button
    private lateinit var btnLimpiar : Button
    private lateinit var btnCerrar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_convertidor)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    public fun iniciarComponentes(){
        txtCantidad = findViewById(R.id.txtCantidad) as EditText
        txtResultado = findViewById(R.id.txtRes) as TextView
        rdbCel = findViewById(R.id.rdbCel) as RadioButton
        rdbFar = findViewById(R.id.rbdFar) as RadioButton
        btnCalcular = findViewById(R.id.btnCalcular) as Button
        btnCerrar = findViewById(R.id.btnCerrar) as Button
        btnLimpiar = findViewById(R.id.btnLimpiar) as Button
    }
    public fun eventosClic(){
        btnCalcular.setOnClickListener(View.OnClickListener {
            //validar
            if (txtCantidad.text.toString().contentEquals(charSequence = "")){
                Toast.makeText(context: this, text: "Falto capturar Cantidad",Toast.LENGTH_SHORT).show();
            }
            else{
                var cantidad : Float = txtCantidad.text.toString().toFloat()
                if (rdbCel.isChecked){
                    var celcius : Float = 0.0f
                    celcius = (cantidad * 9 / 5) + 32;
                    txtResultado.text = celcius.toString()
                }
                if (rdbFar.isChecked){
                   var Fahrenheit: Float =0.0f
                    Fahrenheit = (cantidad - 32) * 5 / 9;
                    txtResultado.text=Fahrenheit.toString()
                }
            }
        })
        btnLimpiar.setOnClickListener(View.OnClickListener {
            txtCantidad.setText("")
            txtResultado.setText("")
        })
        btnCerrar.setOnClickListener(View.OnClickListener {
            finish()
        })
    }
}