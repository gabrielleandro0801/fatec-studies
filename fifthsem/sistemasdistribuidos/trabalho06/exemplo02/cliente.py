import Pyro5.api
from util import ARRAY_OPERACOES, SOMA, MULTIPLICA, SUBTRAI, POTENCIA, DIVIDE


class Cliente:
    def __init__(self):
        self.objeto = Pyro5.api.Proxy("PYRONAME:Matematica")

    def imprime(self, resultado):
        print(f"\n>>> Resultado da operacao: {resultado}\n")

    def consumidor(self):
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

                num_a = float(input('Insira o numero 1: '))
                num_b = float(input('Insira o numero 2: '))

                if opcao == SOMA:
                    self.imprime(self.objeto.soma(num_a, num_b))
                elif opcao == SUBTRAI:
                    self.imprime(self.objeto.subtrai(num_a, num_b))
                elif opcao == MULTIPLICA:
                    self.imprime(self.objeto.multiplica(num_a, num_b))
                elif opcao == DIVIDE:
                    self.imprime(self.objeto.divide(num_a, num_b))
                elif opcao == POTENCIA:
                    self.imprime(self.objeto.potencia(num_a, num_b))

            print('Fim da aplicação!')

        except Exception as e:
            raise e


if __name__ == '__main__':
    cliente = Cliente()
    cliente.consumidor()
