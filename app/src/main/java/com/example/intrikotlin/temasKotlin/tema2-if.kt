package com.example.intrikotlin.temasKotlin

fun main(){
    println("Ingrese el sueldo del empleado.")
    val sueldo = readln().toDouble()
    if(sueldo>3000){
        println("Debe pagar impuestos")
    }else{
        println("No debe pagar impuestos")
    }
}