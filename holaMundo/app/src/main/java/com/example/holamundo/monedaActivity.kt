package com.example.holamundo

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MonedaActivity : AppCompatActivity() {
    private lateinit var txtCantidad: EditText
    private lateinit var spnConversion: Spinner
    private lateinit var btnCalcular: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btnCerrar: Button
    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moneda)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        iniciarComponentes()
        eventosClic()
    }

    private fun iniciarComponentes() {
        txtCantidad = findViewById(R.id.txtMoneda)
        spnConversion = findViewById(R.id.spnConversor)
        btnCerrar = findViewById(R.id.btnCerrar)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnCalcular = findViewById(R.id.btnCalcular)
        txtResultado = findViewById(R.id.txtResultado)

        val items = resources.getStringArray(R.array.array_conversiones)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        spnConversion.adapter = adapter
    }

    private fun eventosClic() {
        var pos = 0
        spnConversion.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                pos = position
                val item = parent?.getItemAtPosition(position).toString()
                Toast.makeText(applicationContext, "Seleccionaste $item", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        btnCalcular.setOnClickListener {
            val dolara = resources.getString(R.string.dolara).toFloat()
            val dolarc = resources.getString(R.string.dolarc).toFloat()
            val euro = resources.getString(R.string.euro).toFloat()
            val cantidadText = txtCantidad.text.toString()

            if (cantidadText.isEmpty()) {
                Toast.makeText(applicationContext, "Falto capturar la cantidad", Toast.LENGTH_SHORT).show()
            } else {
                val cantidad = cantidadText.toFloat()
                val resultado: Float = when (pos) {
                    0 -> cantidad / dolara
                    1 -> cantidad / dolarc
                    2 -> cantidad / euro
                    3 -> cantidad * dolara
                    4 -> cantidad * dolarc
                    5 -> cantidad * euro
                    else -> 0.0f
                }
                txtResultado.text = resultado.toString()
            }
        }

        btnLimpiar.setOnClickListener {
            txtCantidad.setText("")
            txtResultado.setText("")
        }

        btnCerrar.setOnClickListener {
            finish()
        }
    }
}
