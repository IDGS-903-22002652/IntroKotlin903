package com.example.intrikotlin.temasKotlin

fun main(){
    /*
   List
   MutableList
   Set
   MutableSet
   Map
   MutableMap
     */

    var lista = listOf<String>("Lunes","Martes","Miercoles")
    println(lista)/* Imprime todos los valores */
    println(lista.count())/*Imprime la cantidad de valores*/
    println(lista.size)/*Imprime la cantidad de valores*/
    println(lista.get(0))/*Imprime el valor de la primera posicion*/
    println(lista[1])/*Imprime el valor de la segunda posicion*/
    println(lista.indexOf("Miercoles"))/*Imprime el lugar del valor que le proporionamos*/
    println(lista.first())/*Imprime el valor de la primera posicion*/
    println(lista.last())/*Imprime el valor de la ultima posicion*/

    var listaMutable = mutableListOf<String>("Lunes","Martes","Miercoles")
    println(listaMutable)
    listaMutable.add("Jueves")
    println(listaMutable)
    listaMutable.removeAt(0)
    println()


}