package com.example.intrikotlin.practica2

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intrikotlin.R

class OperasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_operas)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        btnCalcular.setOnClickListener { calcularOperacion() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun calcularOperacion() {
        val edt1 = findViewById<EditText>(R.id.edt1)
        val edt2 = findViewById<EditText>(R.id.edt2)
        val resultado = findViewById<TextView>(R.id.resultado)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupOperaciones)

        try {
            val num1 = edt1.text.toString().toDouble()
            val num2 = edt2.text.toString().toDouble()
            val resultadoOperacion: Double

            when (radioGroup.checkedRadioButtonId) {
                R.id.radioSuma -> {
                    resultadoOperacion = num1 + num2
                    resultado.text = "Resultado: $resultadoOperacion"
                }
                R.id.radioResta -> {
                    resultadoOperacion = num1 - num2
                    resultado.text = "Resultado: $resultadoOperacion"
                }
                R.id.radioMultiplicacion -> {
                    resultadoOperacion = num1 * num2
                    resultado.text = "Resultado: $resultadoOperacion"
                }
                R.id.radioDivision -> {
                    if (num2 != 0.0) {
                        resultadoOperacion = num1 / num2
                        resultado.text = "Resultado: $resultadoOperacion"
                    } else {
                        resultado.text = "Error: No se puede dividir entre cero"
                    }
                }
            }
        } catch (e: NumberFormatException) {
            resultado.text = "Error: Ingresa números válidos"
        }
    }
}
