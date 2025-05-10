package com.example.intrikotlin.temasKotlin

fun main(){
    var num:Int
    do {
        println("Ingresa un numero para imprimir tu piramide:")
        num=readln().toInt()
        do{
            var fila = 1
            do{
                var columna = 1
                do{
                    print("*")
                    columna++
                }while(columna<=fila)
                println()
                fila++
            }while(fila<=num)
        }while(false)
    }while(num!=0)
    println("Programa Terminado")
}