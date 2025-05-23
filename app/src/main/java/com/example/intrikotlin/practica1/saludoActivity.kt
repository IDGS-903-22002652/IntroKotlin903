package com.example.intrikotlin.practica1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intrikotlin.R
import android.widget.*
import android.content.Intent

class saludoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_saludo)

        val btnStart=findViewById<Button>(R.id.btnStart)
        val edtName=findViewById<EditText>(R.id.edtName)
        btnStart.setOnClickListener {
            val name = edtName.text.toString()
            if (name.isNotEmpty()) {
                val intent = Intent(this, resultado::class.java)
                intent.putExtra("name", name)
                startActivity(intent)

            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}