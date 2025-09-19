// ================================================
// Videojuego Funcional: poderes como funciones
// Objetivo: practicar funciones de primer nivel en Kotlin
// ================================================

data class Personaje(var nombre: String, var vida: Int, var mana: Int)

typealias Accion = (atacante: Personaje, objetivo: Personaje) -> Unit

fun estado(a: Personaje, b: Personaje) {
    println("${a.nombre}: ${a.vida}  |  ${b.nombre}: ${b.vida}")
    println("----")
}

fun ejecutarTurno(nombreAccion: String, accion: Accion, atacante: Personaje, objetivo: Personaje) {
    println("${atacante.nombre} usa $nombreAccion sobre ${objetivo.nombre}")
    accion(atacante, objetivo)
    estado(atacante, objetivo)
}

fun main() {
    val guerrero = Personaje("Guerrero", vida = 50, mana = 5)
    val mago = Personaje("Mago", vida = 40, mana = 30)

    // FASE A — Funciones como valores
    // TODO 1: Crea dos habilidades como lambdas y asígnalas a variables:
    //   a) golpe: resta 10 de vida al objetivo y muestra un mensaje
    //   b) curar: suma 8 de vida al atacante (ignora objetivo)
    // val golpe: Accion = TODO()
    // val curar: Accion = TODO()

    // TODO 2: Guárdalas en una barra de habilidades (lista).
    // val barra = listOf(/* tus funciones */)

    // FASE B — Pasar funciones como parámetros
    // TODO 3: Usa ejecutarTurno con golpe y luego con curar.
    // ejecutarTurno("Golpe", /*...*/, guerrero, mago)
    // ejecutarTurno("Curación", /*...*/, mago, guerrero)

    // FASE C — Devolver funciones (fábricas)
    // TODO 4: Implementa crearHechizo(elemento, dañoBase) que devuelva una Accion
    // que reste 'dañoBase + (atacante.mana / 10)'.
    // val bolaDeFuego = crearHechizo("Fuego", 9)
    // ejecutarTurno("Bola de Fuego", bolaDeFuego, mago, guerrero)

    // TODO 5 (decorador): Implementa conCritico(base, prob, extra) que devuelva una Accion
    // que ejecute 'base' y, con probabilidad 'prob', reste 'extra' adicional.
    // val golpeCritico = conCritico(golpe, prob = 0.5, extra = 10)
    // ejecutarTurno("Golpe con Crítico", golpeCritico, guerrero, mago)

    // FASE D — Closures (estado que persiste)
    // TODO 6: Implementa aplicarVeneno(turnos, daño) que devuelva una Accion que,
    // cada vez que se use, reste 'daño' y reduzca 'turnos' hasta 0. Luego imprime turnos restantes.
    // val veneno3x4 = aplicarVeneno(3, 4)
    // repetir 4 veces para ver el agotamiento
    // repeat(4) { ejecutarTurno("Veneno", veneno3x4, mago, guerrero) }

    // FASE E — Composición (combos)
    // TODO 7: Implementa encadenar(vararg acciones: Accion): Accion que
    // ejecute varias acciones en secuencia en un mismo turno.
    // val combo = encadenar(golpe, conCritico(golpe, 0.3, 5), curar)
    // ejecutarTurno("Combo triple", combo, guerrero, mago)
}

// =============== RETOS OPCIONALES ===============
// R1: Crea un tipo typealias Efecto = (Personaje) -> Unit y haz un curarEfecto que se aplique después del daño.
// R2: Convierte el modelo a estilo "puro": que las acciones devuelvan copias actualizadas en lugar de mutar.
// R3: Añade escudo temporal: una función que devuelve otra función que reduce el daño recibido durante N usos.
// R4: Mide el tiempo de una acción con una función inline medirTiempo(base: Accion): Accion.
