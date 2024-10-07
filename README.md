# projectkotlin

En Kotlin, hay dos formas de declarar variables: val y var.

val: Declara una variable inmutable (constante).

var: Declara una variable mutable (puede cambiar).

val nombre = "Camila"  // Inmutable

var edad = 25          // Mutable

Kotlin infiere automáticamente el tipo de dato, pero puedes declararlo explícitamente si lo prefieres:

val nombre: String = "Camila"

var edad: Int = 25


Condicional if: Similar a otros lenguajes, pero en Kotlin, también puede devolver un valor.

val edad = 18

val esMayorDeEdad = if (edad >= 18) "Mayor de edad" else "Menor de edad"

Expresión when: Una alternativa al switch de otros lenguajes. Es muy poderosa y más flexible.

val dia = 3

val nombreDia = when (dia) {

    1 -> "Lunes"
    
    2 -> "Martes"
    
    3 -> "Miércoles"
    
    else -> "Otro día"
    
}


Definir funciones en Kotlin es sencillo. Aquí hay un ejemplo básico:

fun saludar(nombre: String): String {

    return "Hola, $nombre"
}

También puedes escribir funciones más compactas:

fun sumar(a: Int, b: Int) = a + b

En este caso, Kotlin infiere el tipo de retorno de la función.



Kotlin introduce una forma segura de manejar valores nulos. Para evitar errores por referencia nula (null pointer exceptions), debes indicar explícitamente cuándo una variable puede ser nula.

var nombre: String? = null  // El signo `?` indica que puede ser nulo

Para acceder a variables que podrían ser nulas, se utilizan verificaciones seguras o el operador Elvis (?:):

println(nombre?.length)  // Esto devolverá null si `nombre` es nulo

val longitud = nombre?.length ?: 0  // Si es nulo, devuelve 0

Bucle for: Para recorrer rangos o colecciones.

for (i in 1..5) {

    println(i)  // Imprime números del 1 al 5
    
}

val lista = listOf("Manzana", "Banana", "Cereza")

for (fruta in lista) {

    println(fruta)
    
}


























