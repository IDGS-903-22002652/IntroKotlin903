/*package com.example.intrikotlin.temasKotlin

import com.github.pemistahl.lingua.api.LanguageDetector
import com.github.pemistahl.lingua.api.LanguageDetectorBuilder

fun main() {
    val detector: LanguageDetector = LanguageDetectorBuilder.fromAllLanguages().build()

    println("Escribe un texto para detectar su idioma:")
    val texto = readLine() ?: ""

    val idioma = detector.detectLanguageOf(texto)
    println("Idioma detectado: ${idioma.name}")
}*/