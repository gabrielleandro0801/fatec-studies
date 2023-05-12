from random import randint
from ConexaoBanco import ConexaoBanco
from time import sleep


class ExecutaTarefaA:
    def __init__(self):
        self.executa_banco = ConexaoBanco()

    def joga_partida_a(self):
        try:
            ID_TAREFA_A = 1

            while True:
                gols_brasil = randint(0, 5)
                gols_argentina = randint(0, 5)
                print(f"A | Inserindo resultado no banco --> Brasil {gols_brasil} x {gols_argentina} Argentina")
                self.executa_banco.edita_resultado(ID_TAREFA_A, gols_brasil, gols_argentina)

                resultado = self.executa_banco.busca_resultado(ID_TAREFA_A)
                print(f"A | Resultado retornado do banco: Brasil {resultado[1]} x {resultado[2]} Argentina\n")

                sleep(2)
        except Exception as e:
            print(e)
            raise e


if __name__ == '__main__':
    executa_tarefa_a = ExecutaTarefaA()
    executa_tarefa_a.joga_partida_a()
