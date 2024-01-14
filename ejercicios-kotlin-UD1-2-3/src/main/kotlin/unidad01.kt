import kotlin.reflect.typeOf

fun ejercicio_U1_04() {
    println("Introduce una temperatura (Grados Celsius): ")

    val gradosCelsius: Double? =
        try {
            readln().toDouble()
        } catch (e: NumberFormatException) {
            println("*** ERROR *** Solo puedes introducir numeros")
            null
        }

    if (gradosCelsius != null) {
        val calculo = (gradosCelsius * 9 / 5) + 32
        println("La temperatura en grados fahrenheit es de $calculo grados fahrenheit")
    }

}

fun ejercicio_U1_06() {
    println("Introduce el precio final del producto: ")

    val importeFinal: Float? =
        try {
            readln().toFloat()
        } catch (e: NumberFormatException) {
            println("*** ERROR *** Solo puedes introducir numeros")
            null
        }

    if (importeFinal != null) {
        val precioIva = importeFinal * 0.1

        val importeSinIva = importeFinal - precioIva

        println("Precio final del producto: $importeFinal")
        println("Precio del iva introducido (10%): $precioIva")
        println("Precio del producto sin IVA: $importeSinIva")
    }
}

fun ejercicio_U1_12() {
    println("Introduce tu peso(KG): ")
    val peso: Double? =
        try {
            readln().toDouble()
        } catch (e: NumberFormatException) {
            println(" *** ERROR *** Solo puedes introducir numeros")
            null
        }

    println("Introduce tu estatura(m): ")
    val estatura: Double? =
        try {
            readln().toDouble()
        } catch (e: NumberFormatException) {
            println("*** ERROR *** Solo puedes introducir numeros")
            null
        }

    if (peso != null && estatura != null) {
        val indice = peso / (estatura * estatura)
        println("Tu índice de masa corporal es ${String.format("%.3f", indice)}")
    }
}

fun ejercicio_U1_15() {
    println("Introduce la cantidad de dinero depositada en la cuenta de ahorros: ")
    val dinero: Double? =
        try {
            readln().toDouble()
        } catch (e: NumberFormatException) {
            println("*** ERROR *** Solo puedes introducir numeros")
            null
        }

    val interes = 0.04
    val anios = 3

    if (dinero != null) {
        for (anio in 1..anios) {
            val saldo = dinero * (1 + interes) * anio
            println("Saldo después del año ${anio}: ${String.format("%.3f", saldo)}")
        }
    }
}

fun ejercicio_U1_18() {
    println("Introduce tu nombre completo")

    try {
        val nombre = readln()
        if (nombre != null && nombre::class.simpleName != "String") {
            val nombreMinuscula = nombre.lowercase()
            val nombreMayuscula = nombre.uppercase()
            val listaNombre = nombreMinuscula.split(" ")
            for (palabra in listaNombre) {
                val inicialMayuscula = palabra.replaceFirstChar { it.uppercase() }
                print("$inicialMayuscula ")
            }

            println("\n${nombreMinuscula}\n${nombreMayuscula}")
        } else {
            throw IllegalArgumentException(" - Introduce tu nombre válido, no un número")
        }
    } catch (e: Exception) {
        println("*** ERROR *** $e - Introduce tu nombre válido")
    }

}

fun ejercicio_U1_20() {
    println("Introduce tu numero de teléfono con este formato (+XX-XXXXXXXXX-XX): ")

    try {
        val numero = readln()
        val listaNumeros = numero.split("-")

        val prefijo = listaNumeros[0]
        val telefono = listaNumeros[1]
        val extension = listaNumeros[2]

        println("Prefijo: $prefijo\nNúmero de teléfono: $telefono\nExtensión: $extension")
    } catch (e: Exception) {
        println("*** ERROR *** $e - Introduce un numero de teléfono válido")
    }
}

fun ejercicio_U1_21() {
    println("Introduce una frase: ")

    try {
        val frase = readln()
        if (frase != null) {
            val fraseInvertida = frase.reversed()

            println("Tu frase invertida es: $fraseInvertida")
        } else {
            throw IllegalArgumentException(" - Por favor, introduzca su frase correctamente")
        }
    } catch (e: Exception) {
        println("*** ERROR *** $e - Introduzca una frase válida")
    }
}

fun ejercicio_U1_22() {
    try {
        println("Introduce una frase: ")
        val frase = readln()
        println("Introduce una vocal: ")
        val vocal = readln()

        if (frase != null && frase::class.simpleName != "Int" && vocal != null && vocal::class.simpleName != "Int") {
            val fraseNueva = frase.replace(vocal.lowercase(),vocal.uppercase())

            println("Tu frase cambiada es: $fraseNueva")
        } else {
            throw IllegalArgumentException(" - Frase o vocal erronea")
        }
    } catch (e: Exception) {
        println("")
    }
}

fun ejercicio_U1_24() {
    try {
        println("Introduce el precio del producto(€) con dos decimales: ")
        val precio = readLine()?.toDouble()

        if (precio != null) {
            val precioRedondeado = String.format("%.2f", precio)
            val (euros,centimos) = precioRedondeado.split("\\.")


            println("Euros: $euros\nCéntimos: $centimos")
        } else {
            throw IllegalArgumentException(" - Solo puedes introducir números")
        }

    } catch (e: IndexOutOfBoundsException) {
        println("*** ERROR *** $e - Asegúrate de introducir un número con dos decimales")
    } catch (e: Exception) {
        println("*** ERROR *** $e - Introduce el precio correctamente")
    }
}

fun ejercicio_U1_25() {
    try {
        println("Introduce tu fecha de nacimiento (DD/MM/YYYY): ")
        val fecha = readln()

        val (dia,mes,anio) = fecha.split("/")

        if (dia.length == 1) {
            val dia = "0$dia"
        }

        if (mes.length == 1) {
            val mes = "0$mes"
        }

        println("Día: $dia Mes: $mes Año: $anio")

    } catch (e: Exception) {
        println("*** ERROR *** $e")
    }
}

fun ejercicio_U1_26() {
    print("Introduce los productos de una compra(xxxxxx,xxxxxx,xxxxxx): ")
    val productos = readLine()

    if (productos != null) {
        val producto = productos.split(",")
        println(producto)
    } else {
        println("Error al leer la entrada.")
    }
}

fun ejercicio_U1_27() {
    try {
        print("Introduce el nombre del producto: ")
        val nombre = readLine() ?: throw IllegalArgumentException("Error al leer el nombre del producto.")

        print("Introduce el precio del producto: ")
        val precioInput = readLine() ?: throw IllegalArgumentException("Error al leer el precio del producto.")
        val precio = precioInput.toDouble()

        print("Introduce la cantidad: ")
        val nUnidadesInput = readLine() ?: throw IllegalArgumentException("Error al leer la cantidad.")
        val nUnidades = nUnidadesInput.toInt()

        val costeTotal = nUnidades * precio

        val precioFormateado = "%6.2f".format(precio)
        val nUnidadesFormateado = "%03d".format(nUnidades)
        val costeTotalFormateado = "%8.2f".format(costeTotal)

        println("Nombre: $nombre\nPrecio: $precioFormateado\nUnidades: $nUnidadesFormateado\nPrecio final: $costeTotalFormateado")
    } catch (e: IllegalArgumentException) {
        println("*** ERROR *** ${e.message}")   //"message proporciona una descripcion del error asociado proporcionado por la propia clase"
    } catch (e: NumberFormatException) {
        println("*** ERROR *** Formato de número incorrecto. Introduce un número válido.")
    } catch (e: Exception) {
        println("*** ERROR *** ${e.message}")
    }
}