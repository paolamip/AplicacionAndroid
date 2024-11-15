package com.example.holamundo

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.setPadding
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import java.io.Serializable
import kotlin.random.Random

class cotizacion2Activity : Serializable{
    private lateinit var txtCliente : TextView
    private lateinit var txtFolio : TextView
    private lateinit var txtDescripcion : TextView
    private lateinit var txtPrecio : EditText
    private lateinit var txtPorPagI : EditText
    private lateinit var rbd12 : RadioButton
    private lateinit var rbd24 : RadioButton
    private lateinit var  rbd36 : RadioButton
    private lateinit var rbd48 : RadioButton
    private lateinit var txtPagoInicial : TextView
    private lateinit var txtTotalFin : TextView
    private lateinit var txtPagoMensual : TextView

    private lateinit var btnCalcular : Button
    private lateinit var btnLimpiar : Button
    private lateinit var btnCerrar : Button

    override fun on Create(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cotizacion2)
        iniciarComponentes()
        eventosClic

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)){v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.sysremBar())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun iniciarComponentes(){
        txtCliente = findViewById(R.id.txtCliente) as TextView
        txtFolio = findViewById(R.id.txtFolio) as TextView
        txtDescripcion = findViewById(R.id.txtDescripcion) as EditText
        txtPrecio = findViewById(R.id.txtPrecio) as EditText
        txtPorPagI = findViewById(R.id.txtPorcentaje) as EditText
        txtPagoInicial = findViewById(R.id.txtPagoInicial) as EditText
        txtPagoMensual = findViewById(R.id.txtPagoMensual) as EditText
        txtTotalFin = findViewById(R.id.txtTotalFin) as TextView

        rdb12 = findViewById(R.id.rdb12) as RadioButton
        rdb24 = findViewById(R.id.rdb24) as RadioButton
        rdb36 = findViewById(R.id.rdb36) as RadioButton
        rdb48 = findViewById(R.id.rdb48) as RadioButton

        btnCalcular = findViewById(R.id.btnCalcular) as Button
        btnLimpiar = findViewById(R.id.btnLimpiar) as Button
        btnCerrar = findViewById(R.id.btnCerrar) as Button

        var strCliente: String = intent.getStringExtra(name: "Cliente").toString()
        txtCliente.text = strCliente.toString();

        var folio : Int = abs(Cotizacion().generaFolio())
        txtFolio.text="Folio : " + folio.toString()
    }
    public fun eventosClic(){
        btnCalcular.setOnClickListener(View.OnClickListener {
            var cotizacion = Cotizacion()
            if(txtDescripcion.text.toString().contentEquals(charSequence = "") ||
                    txtPrecio.text.toString().contentEquals(charSequence = "") ||
                    txtPorPagI.text.toString().contentEquals(charSequence = "")){
                Toast.makeText(context: this, text: "Falto capturar algun dato",
                Toast.LENGTH_SHORT).show()
            }
            else{
                txtFolio.text = cotizacion.generaFolio().toString()
                cotizacion.descripcion = txtDescripcion.text.toString()
                cotizacion.precio = txtPrecio.text.toString().toFloat()
                cotizacion.porPagInicial = txtPorPagI.text.toString().toFloat()

                if (rbd12.isChecked) cotizacion.plazos=12
                if (rbd24.isChecked) cotizacion.plazos=24
                if (rbd36.isChecked) cotizacion.plazos=36
                if (rbd48.isChecked) cotizacion.plazos=48

                txtPagoInicial.text = "Pago Inicial" + ":" + cotizacion.calcularPagoInicial().toString() + ":"
                txtTotalFin.text = "Total a Financiar" + ":" + cotizacion.calcularTotalFin().toString()
                txtPagoMensual.text = "Pago Mensual" + ":" + cotizacion.calcularPagoMensual().toString()

            }
            btnLimpiar.setOnClickListener(View.OnClickListener {
                txtFolio.text=""
                txtPagoInicial.text="Pago Inicial"
                txtTotalFin.text = "Total a Financiar"
                txtPagoMensual.text = "Pago Mensual"

                txtDescripcion.setText("")
                txtPrecio.setText("")
                txtPorPagI.setText("")

                rdb12.isChecked=true
            })
            btnCerrar.setOnClickListener(View.OnClickListener {
                finish()
            })
        })
    }
    var numCotizacion:Int=0
    var descripcion:String=""
    var porPagInicial:Float= 0.0f
    var precio :Float = 0.0f;
    var plazos :Int = 0;
    constructor(){
        this.numCotizacion = 0;
        this.descripcion = "";
        this.porPagInicial = 0.0f;
        this.precio = 0.0f
        this.plazos = 0;
    }
    public fun calcularPagoInicial():Float{
        var pagoInicial:Float=0.0f
        pagoInicial = precio * (this.porPagInicial)/100
        return pagoInicial
    }
    public fun calcularTotalFin():Float{
        return this.precio-this.calcularPagoInicial()
    }
    public fun calcularPagoMensual():Float{
        return this.calcularTotalFin()/this.plazos
    }
    public fun generaFolio():Int{
        return Random(333).nextInt()%1001
    }
        }
