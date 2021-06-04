fun main() {

//
//    val listImutavel = listOf<String>() // é uma lista imutável
//
//    val listMutável = mutableListOf(1, 2, 3)
//    listMutável.add(4)
//
//    val setImutavel = setOf(1, 2, 3, 4, 2) // não considera itens em duplicidade
//    println(setImutavel)
//
//    val setMutavel = mutableSetOf(4, 3, 2, 1, 4)
//
//    val mapImutavel = mapOf(
//        123 to "Samuel",
//        321 to "JP",
//        321 to "Mi"
//
//    )
//    mapImutavel.forEach {
//        println("A minha key é${it.key} e meu value é ${it.value}")
//    }
//
//    val mapMutavel = mutableMapOf(
//        123 to "Samuel",
//        321 to "JP",
//        321 to "Mi"
//    )
//    mapMutavel.put(456, "Santos")
//    println(mapMutavel)
//    mapMutavel.remove(123)
//    println(mapMutavel)
//
//
//    val loteriaDosSonhos = mutableMapOf(
//        0 to "Ovos",
//        1 to "Água",
//        2 to "Escopeta",
//        3 to "Cavalo",
//        4 to "Dentista",
//        5 to "Fogo"
//    )
//
//    val chamarAmigos = mutableMapOf(
//        "Joao" to listOf("Juan", "Fissura", "Maromba"),
//        "Miguel" to listOf("Night Watch", "Bruce Wayne", "Tampinha"),
//        "Maria" to listOf("Wonder Woman", "Mary", "Marilene"),
//        "Lucas" to listOf("Lukinha", "Jorge", "George")
//    )
//
//    loteriaDosSonhos.forEach {
//        println("chave: ${it.key} valor: ${it.value}")
//    }
//
//    chamarAmigos.forEach { entry ->
//        entry.value.forEach { apelido ->
//            println("${entry.key} - ${apelido.toString()}")
//        }
//    }

    var nomesApelido = Imprimir(mutableMapOf("Samuel" to "Santos"))
    var nome22 = Imprimir(mutableMapOf("JP" to "Aug"))
    var nome33 = Imprimir(mutableMapOf("ABC" to "CDE"))

    nomesApelido.imprimirNome(nomesApelido)
    nome22.imprimirNome(nome22)
    nome33.imprimirNome(nome33)

}

class Imprimir(

    val nome: MutableMap<String, String>

) {

    fun imprimirNome(imprimir: Imprimir) {

        nome.forEach {
            println("${it.key} e ${it.value}")


        }
    }
}


















