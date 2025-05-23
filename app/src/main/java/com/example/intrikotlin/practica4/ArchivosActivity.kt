package com.example.intrikotlin.practica4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intrikotlin.R
import android.widget.*
import java.io.FileNotFoundException


class ArchivosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_archivos)

        val btnGuardar = findViewById<Button>(R.id.saveButton)
        val btnLeer = findViewById<Button>(R.id.readButton)
        val btnBorrar = findViewById<Button>(R.id.btnBorrar)
        val outputText = findViewById<TextView>(R.id.outputText)
        val inputText = findViewById<EditText>(R.id.inputText)

        btnGuardar.setOnClickListener {
            val texto = inputText.text.toString() + "\n"
            //val archivo = openFileOutput("datos.txt", MODE_APPEND)
            try {
                openFileOutput("datos.txt", MODE_APPEND).use {
                    it.write(texto.toByteArray())
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        btnLeer.setOnClickListener {
            try {
                val contenido = openFileInput("datos.txt").bufferedReader().useLines { lines ->
                    lines.joinToString("\n")
                }
                outputText.text = contenido.ifEmpty { "El archivo está vacío" }
            } catch (e: FileNotFoundException) {
                outputText.text = "No se encontró el archivo"
            } catch (e: Exception) {
                outputText.text = "Error al leer el archivo"
                e.printStackTrace()
            }
        }

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
