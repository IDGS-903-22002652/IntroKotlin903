package com.example.intrikotlin.cinepolis

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intrikotlin.R
import android.widget.*

class CinepolisActivity : AppCompatActivity() {

    private val precioBoleto = 12.0
    private val maxBoletosPorPersona = 7

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_cinepolis)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.clCinepolis)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etCompradores = findViewById<EditText>(R.id.etCompradores)
        val etBoletos = findViewById<EditText>(R.id.etBoletos)
        val rbSi = findViewById<RadioButton>(R.id.rbSi)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        btnCalcular.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val compradoresText = etCompradores.text.toString()
            val boletosText = etBoletos.text.toString()

            if (nombre.isEmpty() || compradoresText.isEmpty() || boletosText.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val compradores = compradoresText.toIntOrNull()
            val boletos = boletosText.toIntOrNull()

            if (compradores == null || boletos == null || compradores <= 0 || boletos <= 0) {
                Toast.makeText(this, "Ingresa valores válidos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (boletos > compradores * maxBoletosPorPersona) {
                Toast.makeText(this, "Máximo 7 boletos por persona", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            var total = boletos * precioBoleto

            total *= when {
                boletos in 3..5 -> 0.90 // 10%
                boletos >= 6    -> 0.85 // 15%
                else -> 1.0     // Sin descuento
            }

            if (rbSi.isChecked) {
                total *= 0.90 // 10% adicional
            }

            tvResultado.text = "Boletos a Pagar:\n$${"%.2f".format(total)}"
        }
    }
}