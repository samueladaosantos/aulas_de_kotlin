fun main() {

    try {

        var animais: MutableList<String> = mutableListOf()
        animais.add("Pato")
        animais.add("Cachorro")
        animais.add("Gato")

        println(animais[3])

    } catch (e: IndexOutOfBoundsException) {
        println("Erro ignorado!")
    }

    try {
        var animais2: MutableList<String> = mutableListOf()
        animais2.add("Pato")
        animais2.add("Cachorro")
        animais2.add("Gato")

        println(animais2[5])
    } catch (e: IndexOutOfBoundsException) {
        println("Erro ignorado again!")
    }

    var testeClass = CalculoMatematico()
    testeClass.dividao(4,0)

}

class CalculoMatematico() {

    fun dividao(num1: Int, num2: Int) {
        try {
            var resultado = num1 / num2
        } catch (e: ArithmeticException) {
            println("Erro ignorado again again")

        }
    }
}



