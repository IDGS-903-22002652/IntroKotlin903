package com.example.intrikotlin.temasKotlin

import kotlin.math.sqrt

fun main() {
    do {
        println("1. Resolver e  cuación")
        println("2. Salir")
        print("Seleccione una opción: ")

        when (readLine()?.toIntOrNull()) {
            1 -> resolverEcuacion()
            2 -> {
                println("Saliendo del programa...")
                return
            }
            else -> println("Opción no válida. Intente nuevamente.")
        }
    } while (true)
}

fun resolverEcuacion() {
    println("\nForma general: ax² + bx + c = 0")

    fun leerNumero(mensaje: String): Double {
        while (true) {
            print(mensaje)
            readLine()?.toDoubleOrNull()?.let { return it }
                ?: println("Error: Ingrese un número válido")
        }
    }

    val a = leerNumero("Ingrese a: ")
    val b = leerNumero("Ingrese b: ")
    val c = leerNumero("Ingrese c: ")

    if (a == 0.0) {
        println("\nNo es ecuación cuadrática (a no puede ser cero)")
        return
    }

    val discriminante = b * b - 4 * a * c
    val raiz = sqrt(kotlin.math.abs(discriminante))
    val denominador = 2 * a

    println("\nResultados:")
    when {
        discriminante > 0 -> println("Dos soluciones reales:\nx₁ = ${(-b + raiz)/denominador}\nx₂ = ${(-b - raiz)/denominador}")
        discriminante == 0.0 -> println("Solución única:\nx = ${-b/denominador}")
        else -> println("Soluciones complejas:\nx = ${-b/denominador} ± ${raiz/denominador}i")
    }
}