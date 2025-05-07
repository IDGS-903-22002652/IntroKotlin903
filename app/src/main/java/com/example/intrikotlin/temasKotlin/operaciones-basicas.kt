package com.example.intrikotlin.temasKotlin

fun main() {
    do {
        println("Seleccione una opcion\n" +
                "1.-Sumar\n" +
                "2.-Restar\n" +
                "3.-Multiplicar\n" +
                "4.-Dividir\n" +
                "5.-Salir")
        var opcion = readln().toInt()

        when (opcion) {
            1 -> {
                println("Ingrese un numero")
                val numero1 = readln().toDouble()
                println("Ingrese otro numero")
                val numero2 = readln().toDouble()
                val suma = numero1 + numero2
                println("La suma del numero $numero1 y $numero2 es = $suma\n")
                var saltar=readln()
            }
            2 -> {
                println("Ingrese un numero")
                val numero1 = readln().toDouble()
                println("Ingrese otro numero")
                val numero2 = readln().toDouble()
                val resta = numero1 - numero2
                println("La resta del numero $numero1 y $numero2 es = $resta\n")
                var saltar=readln()

            }
            3 -> {
                println("Ingrese un numero")
                val numero1 = readln().toDouble()
                println("Ingrese otro numero")
                val numero2 = readln().toDouble()
                val multiplicacion = numero1 * numero2
                println("La multiplicación del numero $numero1 y $numero2 es = $multiplicacion\n")
                var saltar=readln()

            }
            4 -> {
                println("Ingrese un numero")
                val numero1 = readln().toDouble()
                println("Ingrese otro numero")
                val numero2 = readln().toDouble()
                if (numero2 != 0.0) {
                    val division = numero1 / numero2
                    println("La división del numero $numero1 y $numero2 es = $division\n")
                } else {
                    println("Error: No se puede dividir entre cero\n")
                }
                var saltar=readln()
            }
            5 -> println("Saliendo")
            else -> println("Opción no válida, intente de nuevo\n")
        }
    } while (opcion != 5)
}