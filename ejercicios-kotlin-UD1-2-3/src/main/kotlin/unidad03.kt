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
    try {
        val creditosAsignaturas = mapOf(
            "Matemáticas" to 6,
            "Física" to 4,
            "Química" to 5
        )

        for ((asignatura, creditos) in creditosAsignaturas) {
            println("$asignatura tiene $creditos créditos")
        }

        val totalCreditos = creditosAsignaturas.values.sum()
        println("Número total de créditos: $totalCreditos")
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}

fun pedirDato(mensaje: String): String {
    print(mensaje)
    return readLine() ?: ""
}

fun mostrarDiccionario(diccionario: Map<String, Any>) {
    println("Contenido del diccionario:")
    for ((clave, valor) in diccionario) {
        println("$clave: $valor")
    }
    println()
}

fun ejerciciosDiccionarios_U3_03() {
    val informacionPersona = mutableMapOf<String, Any>()

    println("Ingresa información sobre la persona:")

    informacionPersona["nombre"] = pedirDato("Nombre: ")
    mostrarDiccionario(informacionPersona)

    informacionPersona["edad"] = pedirDato("Edad: ").toInt()
    mostrarDiccionario(informacionPersona)

    informacionPersona["sexo"] = pedirDato("Sexo: ")
    mostrarDiccionario(informacionPersona)

    informacionPersona["telefono"] = pedirDato("Teléfono: ")
    mostrarDiccionario(informacionPersona)

    informacionPersona["correo"] = pedirDato("Correo electrónico: ")
    mostrarDiccionario(informacionPersona)
}

fun pedirPrecio(mensaje: String): Double {
    while (true) {
        print(mensaje)
        val precio = readLine()?.toDoubleOrNull()
        if (precio != null && precio > 0) {
            return precio
        } else {
            println("Por favor, introduce un precio válido.")
        }
    }
}

fun mostrarListaCompra(cestaCompra: Map<String, Double>) {
    println("Lista de la compra")
    println("-----------------------")

    for ((articulo, precio) in cestaCompra) {
        println("$articulo\t\t$precio")
    }

    println("-----------------------")
    val totalCoste = cestaCompra.values.sum()
    println("Total\t\t\t$totalCoste")
}

fun ejerciciosDiccionarios_U3_04() {
    val cestaCompra = mutableMapOf<String, Double>()

    do {
        val articulo = pedirDato("Introduce el artículo (o 'terminar' para finalizar): ")
        if (articulo.toLowerCase() == "terminar") {
            break
        }

        val precio = pedirPrecio("Introduce el precio del artículo: ")

        cestaCompra[articulo] = precio
    } while (true)

    mostrarListaCompra(cestaCompra)
}

fun crearDiccionario(): Map<String, String> {
    println("Introduce las palabras en español e inglés separadas por dos puntos, y cada par separado por comas:")
    val entradaUsuario = readLine() ?: ""

    val pares = entradaUsuario.split(',')

    val diccionario = mutableMapOf<String, String>()
    for (par in pares) {
        val (palabra, traduccion) = par.split(':')
        diccionario[palabra.trim()] = traduccion.trim()
    }

    return diccionario
}

fun traducirFrase(fraseEspanol: String, diccionario: Map<String, String>): String {
    val palabras = fraseEspanol.split(" ")

    val fraseTraducida = palabras.map { diccionario[it] ?: it }

    return fraseTraducida.joinToString(" ")
}

fun ejerciciosDiccionarios_U3_05() {
    val diccionario = crearDiccionario()

    print("Introduce una frase en español: ")
    val fraseEspanol = readLine() ?: ""

    val fraseTraducida = traducirFrase(fraseEspanol, diccionario)

    println("Frase traducida: $fraseTraducida")
}

fun solicitarEntrada(mensaje: String): String {
    print(mensaje)
    return readLine() ?: ""
}

fun mostrarMenu() {
    println("\nMenú:")
    println("(1) Añadir cliente")
    println("(2) Eliminar cliente")
    println("(3) Mostrar cliente")
    println("(4) Listar todos los clientes")
    println("(5) Listar clientes preferentes")
    println("(6) Terminar")
}

fun agregarCliente(baseDeDatos: MutableMap<String, MutableMap<String, Any>>) {
    val nif = solicitarEntrada("Introduce el NIF del cliente: ")
    val nombre = solicitarEntrada("Introduce el nombre del cliente: ")
    val direccion = solicitarEntrada("Introduce la dirección del cliente: ")
    val telefono = solicitarEntrada("Introduce el teléfono del cliente: ")
    val correo = solicitarEntrada("Introduce el correo del cliente: ")
    val esPreferente = solicitarEntrada("¿Es cliente preferente? (true/false): ").toBoolean()

    val cliente = mutableMapOf(
        "nombre" to nombre,
        "direccion" to direccion,
        "telefono" to telefono,
        "correo" to correo,
        "preferente" to esPreferente
    )

    baseDeDatos[nif] = cliente
    println("Cliente añadido correctamente.")
}

fun eliminarCliente(baseDeDatos: MutableMap<String, MutableMap<String, Any>>) {
    val nif = solicitarEntrada("Introduce el NIF del cliente que deseas eliminar: ")

    if (baseDeDatos.containsKey(nif)) {
        baseDeDatos.remove(nif)
        println("Cliente eliminado correctamente.")
    } else {
        println("Cliente no encontrado en la base de datos.")
    }
}

fun mostrarCliente(baseDeDatos: MutableMap<String, MutableMap<String, Any>>) {
    val nif = solicitarEntrada("Introduce el NIF del cliente que deseas mostrar: ")

    if (baseDeDatos.containsKey(nif)) {
        val cliente = baseDeDatos[nif]!!
        println("\nDatos del cliente:")
        cliente.forEach { (clave, valor) -> println("$clave: $valor") }
    } else {
        println("Cliente no encontrado en la base de datos.")
    }
}

fun listarTodosLosClientes(baseDeDatos: MutableMap<String, MutableMap<String, Any>>) {
    println("\nLista de todos los clientes:")
    baseDeDatos.forEach { (nif, cliente) ->
        val nombre = cliente["nombre"]
        println("NIF: $nif, Nombre: $nombre")
    }
}

fun listarClientesPreferentes(baseDeDatos: MutableMap<String, MutableMap<String, Any>>) {
    println("\nLista de clientes preferentes:")
    baseDeDatos.filterValues { it["preferente"] == true }.forEach { (nif, cliente) ->
        val nombre = cliente["nombre"]
        println("NIF: $nif, Nombre: $nombre")
    }
}

fun ejerciciosDiccionarios_U3_06() {
    val baseDeDatosClientes = mutableMapOf<String, MutableMap<String, Any>>()

    while (true) {
        mostrarMenu()
        val opcion = readLine()

        when (opcion) {
            "1" -> agregarCliente(baseDeDatosClientes)
            "2" -> eliminarCliente(baseDeDatosClientes)
            "3" -> mostrarCliente(baseDeDatosClientes)
            "4" -> listarTodosLosClientes(baseDeDatosClientes)
            "5" -> listarClientesPreferentes(baseDeDatosClientes)
            "6" -> {
                println("Programa terminado.")
                break
            }
            else -> println("Opción no válida. Por favor, elige una opción del 1 al 6.")
        }
    }
}

fun dividirDirectorioClientes(directorio: String): Map<String, Map<String, Any>> {
    val lineas = directorio.split("\n").filter { it.isNotBlank() }
    val campos = lineas[0].split(";")

    return lineas.drop(1).associate { linea ->
        val valores = linea.split(";")
        val nif = valores[0]
        val cliente = campos.zip(valores.drop(1)).toMap()
        nif to cliente
    }
}

fun ejerciciosDiccionarios_U3_07() {
    val directorioClientes = """
        nif;nombre;email;teléfono;descuento
        01234567L;Luis González;luisgonzalez@mail.com;656343576;12.5
        71476342J;Macarena Ramírez;macarena@mail.com;692839321;8
        63823376M;Juan José Martínez;juanjo@mail.com;664888233;5.2
        98376547F;Carmen Sánchez;carmen@mail.com;667677855;15.7
    """.trimIndent()

    val diccionarioClientes = dividirDirectorioClientes(directorioClientes)
    println(diccionarioClientes)
}
