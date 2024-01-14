fun main() {

    var op: Int

    do {

        mostrarMenuPpal()
        op = pedirOpcion(0, 3)

        if (op != 0) {
            mostrarMenu(op)
        }

    } while (op != 0)

}


fun mostrarMenuPpal() {
    println("1. Ejercicios U1")
    println("2. Ejercicios U2")
    println("3. Ejercicios U3")
}


fun mostrarMenu(tipo: Int) {
    var op = -1

    when (tipo) {
        1 -> {
            println("1. Ejercicio 04")
            println("2. Ejercicio 06")
            println("3. Ejercicio 12")
            println("4. Ejercicio 15")
            println("5. Ejercicio 18")
            println("6. Ejercicio 20")
            println("7. Ejercicio 21")
            println("8. Ejercicio 22")
            println("9. Ejercicio 24")
            println("10. Ejercicio 25")
            println("11. Ejercicio 26")
            println("12. Ejercicio 27")

            op = pedirOpcion(0,12)

            when (op) {
                1 -> ejercicio_U1_04()
                2 -> ejercicio_U1_06()
                3 -> ejercicio_U1_12()
                4 -> ejercicio_U1_15()
                5 -> ejercicio_U1_18()
                6 -> ejercicio_U1_20()
                7 -> ejercicio_U1_21()
                8 -> ejercicio_U1_22()
                9 -> ejercicio_U1_24()
                10 -> ejercicio_U1_25()
                11 -> ejercicio_U1_26()
                12 -> ejercicio_U1_27()
            }
        }
        2 -> {
            println("1. EjCondicion 02")
            println("2. EjCondicion 03")
            println("3. EjCondicion 06")
            println("4. EjCondicion 08")
            println("5. EjCondicion 10")
            println("6. EjIterativa 02")
            println("7. EjIterativa 04")
            println("8. EjIterativa 06")
            println("9. EjIterativa 07")
            println("10. EjIterativa 08")
            println("11. EjIterativa 13")
            println("12. EjIterativa 15")
            println("13. EjIterativa 18")
            println("14. EjIterativa 19")
            println("15. EjIterativa 25")
            println("16. EjExcepcion 02")
            println("17. EjExcepcion 03")
            println("18. EjExcepcion 04")

            op = pedirOpcion(0,18)

            when (op) {
                1 -> ejerciciosCondicionales_U2_1()
                2 -> ejerciciosCondicionales_U2_2()
                3 -> ejerciciosCondicionales_U2_3()
                4 -> ejerciciosCondicionales_U2_4()
                5 -> ejerciciosCondicionales_U2_5()
                6 -> ejerciciosIterativas_U2_1()
                7 -> ejerciciosIterativas_U2_2()
                8 -> ejerciciosIterativas_U2_3()
                9 -> ejerciciosIterativas_U2_4()
                10 -> ejerciciosIterativas_U2_5()
                11 -> ejerciciosIterativas_U2_6()
                12 -> ejerciciosIterativas_U2_7()
                13 -> ejerciciosIterativas_U2_8()
                14 -> ejerciciosIterativas_U2_9()
                15 -> ejerciciosIterativas_U2_10()
                16 -> ejerciciosExcepciones_U2_1()
                17 -> ejerciciosExcepciones_U2_2()
                18 -> ejerciciosExcepciones_U2_3()
            }

        }
        3 -> {
            println("1. EjListas 04")
            println("2. EjListas 06")
            println("3. EjListas 08")
            println("4. EjListas 09")
            println("5. EjListas 10")
            println("6. EjListas 13")
            println("7. EjDiccionarios 03")
            println("8. EjDiccionarios 05")
            println("9. EjDiccionarios 06")
            println("10. EjDiccionarios 07")
            println("11. EjDiccionarios 08")
            println("12. EjDiccionarios 10")
            println("13. EjDiccionarios 11")
            println("14. EjConjuntos 01")
            println("15. EjConjuntos 02")
            println("16. EjConjuntos 03")
            println("17. EjConjuntos 04")
            println("18. EjConjuntos 05")
            println("19. EjConjuntos 06")

            op = pedirOpcion(0,19)

            when (op) {
                1 -> ejerciciosListas_U3_01()
                3 -> ejerciciosListas_U3_03()
                5 -> ejerciciosListas_U3_05()
                6 -> ejerciciosListas_U3_06()
                7 -> ejerciciosDiccionarios_U3_01()
                8 -> ejerciciosDiccionarios_U3_02()
                9 -> ejerciciosDiccionarios_U3_03()
                10 -> ejerciciosDiccionarios_U3_04()
                11 -> ejerciciosDiccionarios_U3_05()
                12 -> ejerciciosDiccionarios_U3_06()
                13 -> ejerciciosDiccionarios_U3_07()
            }
        }
    }

}


/**
 * Pedir una opción de menú
 * @param min Int - Opción mínima
 * @param max Int - Opción máxima
 */
fun pedirOpcion(min: Int, max: Int) : Int {

    var opcion: Int
    var error: Boolean

    do {
        error = false
        print("Selecciona una opción (0 = SALIR) >> ")
        opcion = try {
            readln().toInt()
        } catch (ex: NumberFormatException) {
            error = true
            -1
        }

        if (error || opcion !in min..max) {
            mensajeError(1)
            error = false
        }
    } while (opcion !in min..max)

    return opcion
}


fun mensajeError(id: Int) {
    when (id) {
        1 -> println("*** Opción no válida")
        else -> println("*** Error desconocido ***")
    }
}