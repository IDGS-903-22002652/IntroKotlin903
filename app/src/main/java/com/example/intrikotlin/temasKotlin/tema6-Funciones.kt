package com.example.intrikotlin.temasKotlin

fun sum(x:Int, y:Int):Int {
    return x + y
}

fun sum2(x:Int, y:Int):Int = x + y

fun saludo(){
    println("Hola")
}

fun main() {
    println(sum(2, 3))
    println(sum2(2, 3))
    saludo()
}