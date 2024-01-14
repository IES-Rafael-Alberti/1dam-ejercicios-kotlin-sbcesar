fun ejerciciosListas_U3_01() {
    print("Introduce los números ganadores de la lotería primitiva: ")
    val numGanador =  readLine()?.toIntOrNull() ?: throw NumberFormatException("Entrada no es un número entero")

    val numerosGanadores = List(5) { numGanador }.toMutableList()
    numerosGanadores.sort()     //la funcion sort solo funciona para listas mutables
    println("Numeros ganadores ordenados: $numerosGanadores")
}

fun ejerciciosListas_U3_02() {

}

fun ejerciciosListas_U3_03() {
    print("Introduce una palabra: ")
    val palabra = readLine()?.toList() ?: emptyList()

    val palabra2 = palabra.reversed()

    if (palabra == palabra2) {
        println("Palabra: $palabra\nPalabra invertida: $palabra2")
    } else {
        println("La palabra no es palíndroma")
    }
}



fun ejerciciosListas_U3_04() {

}

fun


