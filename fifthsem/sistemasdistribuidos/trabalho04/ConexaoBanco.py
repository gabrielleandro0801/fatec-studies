import json
from time import sleep
from db import db_connect


class ConexaoBanco:
    def __init__(self):
        self.connection = db_connect.cursor()
        pass

    def deleta_tabela(self):
        try:
            self.connection.execute("DROP TABLE if exists resultado")
            db_connect.commit()
            print("Tabela resultado deletada")

        except Exception as e:
            print(e)
            raise e

    def cria_tabela(self):
        try:
            self.connection.execute("CREATE table if not exists resultado ("
                                    "id INTEGER NOT NULL PRIMARY KEY,"
                                    "gols_brasil VARCHAR NOT NULL,"
                                    "gols_argentina VARCHAR NOT NULL"
                                    ");")
            db_connect.commit()
            print("Tabela resultado criada\n")

        except Exception as e:
            print(e)
            raise e

    def insere_resultados_iniciais(self):
        try:
            self.connection.execute("INSERT INTO resultado VALUES (1, '0', '0');")
            print('Resultado inicial da tarefa 1 inserido')
            db_connect.commit()

            self.connection.execute("INSERT INTO resultado VALUES (2, '0', '0');")
            print('Resultado inicial da tarefa 2 inserido')
            db_connect.commit()

            resultado_a = self.busca_resultado(1)
            resultado_b = self.busca_resultado(2)

            print('\nTarefa | Gols Brasil | Gols Argentina')
            print(resultado_a)
            print(resultado_b)

        except Exception as e:
            print(e)
            raise e

    def busca_resultados(self):
        try:
            while True:
                self.connection.execute(f"SELECT * FROM resultado;")
                resultados = json.loads(json.dumps(self.connection.fetchall()))

                print('\nBuscando resultados atuais...')
                for resultado in resultados:
                    tarefa = 'A' if int(resultado[0]) == 1 else 'B'
                    print(f"Tarefa {tarefa} | Brasil {resultado[1]} x {resultado[2]} Argentina")
                sleep(5)

        except Exception as e:
            print(e)
            raise e

    def busca_resultado(self, id):
        try:
            self.connection.execute(f"SELECT * FROM resultado where id = {int(id)};")
            resultados = json.loads(json.dumps(self.connection.fetchall()))

            return resultados[0]

        except Exception as e:
            print(e)
            raise e

    def edita_resultado(self, id, gols_brasil, gols_argentina):
        try:
            tarefa = 'A' if id == 1 else 'B'

            query = f"UPDATE resultado SET gols_brasil = '{gols_brasil}', gols_argentina = '{gols_argentina}' WHERE id = {id}"
            self.connection.execute(query)
            db_connect.commit()
            print(f"DB | Resultado da tarefa {tarefa} atualizado | Brasil {gols_brasil} x {gols_argentina} Argentina")

        except Exception as e:
            print(e)
            raise e


if __name__ == '__main__':
    conexao_banco = ConexaoBanco()
    conexao_banco.deleta_tabela()
    conexao_banco.cria_tabela()
    conexao_banco.insere_resultados_iniciais()
    conexao_banco.busca_resultados()
