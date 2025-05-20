package com.example.intrikotlin.temasKotlin

class usuarios() {
    val materia: String = ""
}

class usuarios2(val id: Int, val nombre: String) {
    val materia: String = ""
}

fun main() {
    val alumno = usuarios()
    val alumno2 = usuarios2(1, "Juan")
    println(alumno)
    println(alumno2.nombre)
    alumno2
}