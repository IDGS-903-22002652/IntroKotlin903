package com.example.intrikotlin.diccionario

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.intrikotlin.R
import java.io.OutputStreamWriter

class Guardar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guardar)

        val etEspanol = findViewById<EditText>(R.id.etEspanol)
        val etIngles = findViewById<EditText>(R.id.etIngles)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)

        btnGuardar.setOnClickListener {
            val espanol = etEspanol.text.toString().trim()
            val ingles = etIngles.text.toString().trim()

            if (espanol.isNotEmpty() && ingles.isNotEmpty()) {
                val archivo = OutputStreamWriter(openFileOutput("diccionario.txt", MODE_APPEND))
                archivo.write("$espanol,$ingles\n")
                archivo.close()

                AlertDialog.Builder(this)
                    .setTitle("Éxito")
                    .setMessage("Palabras guardadas con éxito.")
                    .setPositiveButton("OK", null)
                    .show()

                etEspanol.text.clear()
                etIngles.text.clear()
            } else {
                AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Por favor, llena ambos campos.")
                    .setPositiveButton("OK", null)
                    .show()
            }
        }

        btnRegresar.setOnClickListener {
            finish()
        }
    }
}
