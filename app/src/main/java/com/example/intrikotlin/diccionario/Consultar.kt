package com.example.intrikotlin.diccionario

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.intrikotlin.R
import java.io.BufferedReader
import java.io.InputStreamReader

class Consultar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar)

        val rgIdioma = findViewById<RadioGroup>(R.id.rgIdioma)
        val rbEspanol = findViewById<RadioButton>(R.id.rbEspanol)
        val rbIngles = findViewById<RadioButton>(R.id.rbIngles)
        val etBuscar = findViewById<EditText>(R.id.etBuscar)
        val btnBuscar = findViewById<Button>(R.id.btnBuscar)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)

        btnBuscar.setOnClickListener {
            val palabraBuscada = etBuscar.text.toString().trim()
            val buscarEnEspanol = rbEspanol.isChecked
            var resultado = "Palabra no encontrada"

            if (palabraBuscada.isEmpty()) {
                Toast.makeText(this, "Ingresa una palabra", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val archivo = BufferedReader(InputStreamReader(openFileInput("diccionario.txt")))
                var linea: String? = archivo.readLine()

                while (linea != null) {
                    val partes = linea.split(",")
                    if (partes.size == 2) {
                        val espanol = partes[0].trim()
                        val ingles = partes[1].trim()
                        if ((buscarEnEspanol && ingles.equals(palabraBuscada, ignoreCase = true)) ||
                            (!buscarEnEspanol && espanol.equals(palabraBuscada, ignoreCase = true))) {
                            resultado = if (buscarEnEspanol) "Traducción: $espanol" else "Traducción: $ingles"
                            break
                        }
                    }
                    linea = archivo.readLine()
                }

                archivo.close()
            } catch (e: Exception) {
                resultado = "Error al leer el archivo"
            }

            tvResultado.text = resultado
        }

        btnRegresar.setOnClickListener {
            finish()
        }
    }
}
