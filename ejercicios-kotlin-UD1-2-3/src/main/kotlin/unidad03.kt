import kotlin.math.sqrt

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

//Se usa Pair para devolver dos valores, aquí devuelve el valor min y max
fun ordenar(precios: MutableList<Int>): Pair<Int, Int> {
    precios.sort()
    val min = precios.first()
    val max = precios.last()
    return Pair(min, max)
}

fun ejerciciosListas_U3_05() {
    val precios = mutableListOf(50, 75, 46, 22, 80, 65, 8)
    val (min, max) = ordenar(precios)
    println("El precio menor es: $min")
    println("El precio mayor es: $max")
}

fun calcularDesviacionEstandar(numeros: List<Double>, media: Double): Double {
    var sumatoriaCuadrados = 0.0

    for (numero in numeros) {
        val diferencia = numero - media
        sumatoriaCuadrados += diferencia * diferencia
    }

    return sqrt(sumatoriaCuadrados / numeros.size)
}

fun ejerciciosListas_U3_06() {
    print("Introduce una muestra de números separados por comas: ")
    val entrada = readLine()

    if (!entrada.isNullOrBlank()) {
        val numeros = entrada.split(",").map { it.trim().toDouble() }   //convierte la entrada en una lista de numeros

        val media = numeros.average()   //calcula el promedio de una secuencia de numeros
        val desviacionEstandar = calcularDesviacionEstandar(numeros, media)

        println("Media: $media")
        println("Desviación Estándar: $desviacionEstandar")
    } else {
        println("No se proporcionó una entrada válida.")
    }
}

fun calcularPrecioTotal(precios: Map<String, Double>, fruta: String, kilos: Double): Double {
    return if (precios.containsKey(fruta)) {
        precios[fruta]!! * kilos
    } else {
        println("La fruta $fruta no está en el diccionario de precios.")
        0.0
    }
}

fun ejerciciosDiccionarios_U3_01() {
    val preciosFrutas = mapOf(
        "manzana" to 2.5,
        "banana" to 1.8,
        "uva" to 3.2,
        "naranja" to 2.0,
        "pera" to 2.8
    )

    print("Introduce el nombre de la fruta: ")
    val fruta = readLine()?.lowercase()
    print("Introduce el número de kilos: ")
    val kilos = readLine()?.toDoubleOrNull()

    if (fruta != null && kilos != null && kilos > 0) {
        val precioTotal = calcularPrecioTotal(preciosFrutas, fruta, kilos)
        println("El precio de $kilos kilos de $fruta es: $precioTotal")
    } else {
        println("Entrada no válida. Asegúrate de proporcionar valores válidos para la fruta y la cantidad de kilos.")
    }
}

fun ejerciciosDiccionarios_U3_02() {

}

fun ejerciciosDiccionarios_U3_03() {

}

fun ejerciciosDiccionarios_U3_04() {

}
