import rpyc
from util import SOMA, SUBTRAI, MULTIPLICA, POTENCIA, DIVIDE, ARRAY_OPERACOES


def soma(a, b):
    return a + b


def subtrai(a, b):
    return a - b


def multiplica(a, b):
    return a * b


def divide(a, b):
    return a / b


def potencia(a, b):
    return a ** b


def imprime(resultado):
    print(f"\n>>> Resultado da operacao: {resultado}\n")


def executa():
    connection = rpyc.classic.connect("localhost")
    sum = connection.teleport(soma)
    sub = connection.teleport(subtrai)
    mul = connection.teleport(multiplica)
    div = connection.teleport(divide)
    pot = connection.teleport(potencia)

    try:
        while True:
            opcao = int(input('=== Calculadora ===\n'
                              '1 - Somar\n'
                              '2 - Subtrair\n'
                              '3 - Multiplicar\n'
                              '4 - Dividir\n'
                              '5 - Potencia\n'
                              'Qualquer numero - Sair da aplicacao'
                              '\nSua opcao: '))

            if opcao not in ARRAY_OPERACOES:
                break

            num_a = int(input('Insira o numero 1: '))
            num_b = int(input('Insira o numero 2: '))

            if opcao == SOMA:
                imprime(sum(num_a, num_b))
            elif opcao == SUBTRAI:
                imprime(sub(num_a, num_b))
            elif opcao == MULTIPLICA:
                imprime(mul(num_a, num_b))
            elif opcao == DIVIDE:
                imprime(div(num_a, num_b))
            elif opcao == POTENCIA:
                imprime(pot(num_a, num_b))

        print('Fim da aplicação!')

    except Exception as e:
        raise e


if __name__ == '__main__':
    executa()
