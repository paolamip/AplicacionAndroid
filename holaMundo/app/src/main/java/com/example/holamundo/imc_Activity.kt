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

class imc_Activity : AppCompatActivity() {
    private lateinit var txtAltura : EditText
    private lateinit var txtPeso : EditText
    private lateinit var txtResultado : TextView
    private lateinit var btnCalcular : Button
    private lateinit var btnLimpiar : Button
    private lateinit var btnCerrar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun iniciarComponentes(){
        txtAltura = findViewById(R.id.txtAltura) as EditText
        txtPeso = findViewById(R.id.txtPeso) as EditText
        txtResultado = findViewById(R.id.txtResultado) as TextView

        btnCalcular = findViewById(R.id.btnCalcular) as Button
        btnLimpiar = findViewById(R.id.btnLimpiar) as Button
        btnCerrar = findViewById(R.id.btnCerrar) as Button
    }
    fun eventosClic(){
        btnCalcular.setOnClickListener(View.OnClickListener {
            //validar
            if(txtPeso.text.toString().contentEqualas(charSequence="")
            || txtAltura.text.toString().contentEquals(charSequence="")){
                Toast.makeText(context: this,
                    text: "Falto capturar informacion",Toast.LENGTH_SHORT).show()
            }
            else {
                var peso : Float = txtPeso.text.toString().toFloat();
                var altura : Float = txtAltura.text.toString().toFloat();
                var imc : Float = peso/(altura*altura)
                txtResultado.text = imc.toString()
            }
        })
        btnLimpiar.setOnClickListener(View.OnClickListener {
            txtResultado.text=""
            txtPeso.text=("")
            txtAltura.text=("")
        })
        btnCerrar.setOnClickListener(View.OnClickListener {
            val builder = AlterDialog.Builder(context: this)
            builder.setTitle("IMC")
            builder.setMessage ("¿ Desea salir? ")
            builder.setPositiveButton(text: "Aceptar"){
                dialo, which ->
                finish()
        }
            builder.setNegativeButton(text:"Cancelar"){
                dialog, whicch ->
        }
        })

    }
}