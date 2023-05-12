import rpyc
from util import SOMA, SUBTRAI, MULTIPLICA, POTENCIA, DIVIDE, ARRAY_OPERACOES

c = rpyc.connect("localhost", 18861)
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
            print(c.root.imprime(c.root.soma(num_a, num_b)))
        elif opcao == SUBTRAI:
            print(c.root.imprime(c.root.subtrai(num_a, num_b)))
        elif opcao == MULTIPLICA:
            print(c.root.imprime(c.root.multiplica(num_a, num_b)))
        elif opcao == DIVIDE:
            print(c.root.imprime(c.root.divide(num_a, num_b)))
        elif opcao == POTENCIA:
            print(c.root.imprime(c.root.potencia(num_a, num_b)))    

    print('Fim da aplicação!')

except Exception as e:
    raise e
