package com.example.intrikotlin.temasKotlin

fun main(){
    var saldo=0.0
    do{
        println("Sistema de depositos")
        println("1.-Ingresar deposito")
        println("2.-Ver estado de cuenta")
        println("3.-Salir")
        var opcion=readln().toInt()

        when(opcion){
            1->{
                println("Cantidad a depositar")
                var cantidad=readln().toDouble()
                saldo+=cantidad
                println("Se ha depositado $cantidad. Saldo actual: $saldo")
                print("Presione Enter para continuar")
                readln()
            }
            2 -> {
                println("\nEstado de cuenta")
                println("Saldo actual: $saldo")
                print("Presione Enter para continuar")
                readln()
            }
            3 -> {
                println("Cerrando el programa")
            }
        }
    }while (opcion!=3)

}