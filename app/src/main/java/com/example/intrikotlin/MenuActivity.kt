package com.example.intrikotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button
import com.example.intrikotlin.practica2.OperasActivity
import com.example.intrikotlin.cinepolis.CinepolisActivity
import com.example.intrikotlin.practica1.saludoActivity
import com.example.intrikotlin.practica3.ejemplo3Activity
import com.example.intrikotlin.practica4.ArchivosActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val btnOperas = findViewById<Button>(R.id.btnOperas)
        val btnCinepolis = findViewById<Button>(R.id.btnCinepolis)
        val btnPractica1 = findViewById<Button>(R.id.btnPractica1)
        val btnEjemplo3 = findViewById<Button>(R.id.btnEjemplo3)
        val btnArchivos = findViewById<Button>(R.id.btnArchivos)

        btnOperas.setOnClickListener { navegateToOperas() }
        btnCinepolis.setOnClickListener { navegateToCinepolis() }
        btnPractica1.setOnClickListener { navegateToPractica1() }
        btnEjemplo3.setOnClickListener { navegateToEjemplo3() }
        btnArchivos.setOnClickListener { navegateToArchivos() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun navegateToOperas() {
        val intent = Intent(this, OperasActivity::class.java)
        startActivity(intent)
    }
    private fun navegateToCinepolis() {
        val intent = Intent(this, CinepolisActivity::class.java)
        startActivity(intent)
    }
    private fun navegateToPractica1() {
        val intent = Intent(this, saludoActivity::class.java)
        startActivity(intent)
    }
    private fun navegateToEjemplo3() {
        val intent = Intent(this, ejemplo3Activity::class.java)
        startActivity(intent)
    }
    private fun navegateToArchivos() {
        val intent = Intent(this, ArchivosActivity::class.java)
        startActivity(intent)
    }
}
