import java.util.*

fun main() {
    println("Banco Amigão")
    println("*-*-*-*-*-*-*-*-*-*-*-*-")
    println("Digite 01 para entrar.")

    val scanner = Scanner(System.`in`)
    var criarConta = scanner.nextInt()

    while (criarConta >= 0) {
        println("Digte a opção desejada:")
        println("1- Conta Corrente")
        println("2- Conta Poupança")
        var criarConta = scanner.nextInt()

        if (criarConta == 1) {

            var banco = Banco()

            println("Insira o nº da conta:")

            var correnteConta = ContaCorrente(
                numeroDaConta = scanner.nextInt()
            )
            println("Conta Corrente criada com sucesso!")

            banco.inserir(correnteConta)

            println("Procurar conta:")

            banco.procurarConta(numeroDaConta = scanner.nextInt())

            banco.mostrarDados()

            banco.remover(correnteConta)

            break

        } else if (criarConta == 2) {

            var banco = Banco()

            println("Insira o nº da conta:")

            var poupancaConta = ContaPoupanca(
                numeroDaConta = scanner.nextInt()
            )

            banco.inserir(poupancaConta)

            println("Procurar conta:")
            banco.procurarConta(numeroDaConta = scanner.nextInt())

            banco.mostrarDados()
            println("Conta Poupança criada!")
            break
        }
    }
}

abstract class ContaBancaria {

    abstract val numeroDaConta: Int
    abstract val saldo: Double

    abstract fun sacarDinheiro(value: Double)
    abstract fun depositarDinheiro(value: Double)

    fun transferir(value: Double, contaBancaria: ContaBancaria) {
        sacarDinheiro(value)
        contaBancaria.depositarDinheiro(value)
    }
}

open class ContaCorrente(
    override var numeroDaConta: Int,
    override var saldo: Double = 0.0,
    val taxaDeOperacao: Double = 0.0
) : ContaBancaria(), Imprimivel {

    override fun sacarDinheiro(value: Double) {
        if (value > (saldo - taxaDeOperacao)) {
            println("Saldo insuficiente.")
        } else {
            saldo -= value + taxaDeOperacao
            println("Saque efetuado com sucesso. Seu saldo é $saldo")
        }
    }

    override fun depositarDinheiro(value: Double) {
        saldo += value - taxaDeOperacao
        println("Deposito realizado com sucesso. Seu saldo é $saldo")
    }

    override fun mostrarDados() {
        println("O numero da sua conta é $numeroDaConta")
        println("Seu saldo é $saldo")
        println("Taxa de operação é $taxaDeOperacao")
    }
}

open class ContaPoupanca(
    override var numeroDaConta: Int,
    override var saldo: Double = 0.0,
    val limiteDeCredito: Double = 0.0
) : ContaBancaria(), Imprimivel {

    override fun sacarDinheiro(value: Double) {

        if (value > (saldo + limiteDeCredito)) {
            println("Saldo insuficiente.")
        } else {
            saldo -= value
            println("Saque efetuado com sucesso. Seu saldo é $saldo")
        }
    }

    override fun depositarDinheiro(value: Double) {
        saldo += value
        println("Deposito realizado com sucesso. Seu saldo é $saldo")
    }

    override fun mostrarDados() {
        println("O numero da sua conta é $numeroDaConta")
        println("Seu saldo é $saldo")
        println("Limite de crédito é $limiteDeCredito")
    }
}

interface Imprimivel {

    fun mostrarDados() {

    }
}

class Relatorio() : Imprimivel {

    fun gerarRelatorio(imprimivel: Imprimivel) {
        imprimivel.mostrarDados()
    }
}

class Banco() : Imprimivel {

    var listaContas = mutableListOf<ContaBancaria>()

    fun inserir(ContaBancaria: ContaBancaria) {
        listaContas.add(ContaBancaria)
        println("Conta inserida com sucesso!")
    }

    fun remover(ContaBancaria: ContaBancaria) {
        for (i in listaContas) {
            if (i == ContaBancaria) {
                listaContas.remove(ContaBancaria)
                println("Conta bancária removida com sucesso!")
                break
            }
        }
    }

    fun procurarConta(numeroDaConta: Int) {
        for (i in listaContas) {
            if (i.numeroDaConta == numeroDaConta) {
                println("Conta bancária já cadastrada!")
                break
            } else {
                null
            }
        }
    }

    override fun mostrarDados() {
        listaContas?.forEach() {
            println("O número da conta é ${it.numeroDaConta}")
            println("O saldo da conta é ${it.saldo}")

        }
    }
}

