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






















