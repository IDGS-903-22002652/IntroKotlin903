package com.example.intrikotlin.diccionario

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intrikotlin.R
import android.widget.*
import android.content.Intent

class Diccionario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_diccionario)

        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val btnConsultar = findViewById<Button>(R.id.btnConsultar)

        btnGuardar.setOnClickListener { navegateToGuardar() }
        btnConsultar.setOnClickListener { navegateToConsultar() }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun navegateToGuardar(){
        val intent = Intent(this, Guardar::class.java)
        startActivity(intent)
    }

    private fun navegateToConsultar(){
        val intent = Intent(this, Consultar::class.java)
        startActivity(intent)
    }
}