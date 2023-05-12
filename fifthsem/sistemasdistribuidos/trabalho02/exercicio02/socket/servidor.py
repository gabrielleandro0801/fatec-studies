import socket
from socket import AF_INET, SOCK_STREAM


HOST = '127.0.0.1'
QUANTIDADE_BYTES = 1024
PORTA_BASE = 5000


def cria_servidores(quantidade):
    global TCP_BASE

    servidores = []
    for i in range(quantidade):
        servidor = {
            'tcp': socket.socket(family=AF_INET, type=SOCK_STREAM),
            'porta': PORTA_BASE + (i+1),
            'con': '' 
        }
        servidores.append(servidor)
    return servidores


def inicia_conexoes(servidores):
    for i in range(len(servidores)):
        print(f"Aguardando conexao {i+1}...")
        servidores[i]['tcp'].bind((HOST, servidores[i]['porta']))
        servidores[i]['tcp'].listen(1)
        servidores[i]['con'], _ = servidores[i]['tcp'].accept()
        print(f"Conexao {i+1} realizada")
    print('\n')


def recebe_linhas(servidores):
    for i in range(len(servidores)):
        linha = servidores[i]['con'].recv(QUANTIDADE_BYTES).decode()
        linha = linha[:-1]
        linha_resultado = calcula_soma(linha)
        print(f'Resultado linha {i+1}: [{linha_resultado}]')
        servidores[i]['con'].send(linha_resultado.encode())


def calcula_soma(linha):
    valores = linha.split(';')

    linha_resultado = ''
    iteracao = int((len(valores))/2)
    
    posicao = 0
    for i in range(iteracao):
        linha_resultado += str(int(valores[posicao]) + int(valores[posicao+1])) + ';'
        posicao = posicao + 2

    return linha_resultado


if __name__ == '__main__':
    servidor_pai = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    servidor_pai.bind((HOST, PORTA_BASE))
    servidor_pai.listen(1)
    con, cliente = servidor_pai.accept()
    print('Servidor pai conectado\n')
    quantidade_linhas = int(con.recv(QUANTIDADE_BYTES).decode())

    servidores = cria_servidores(quantidade_linhas)
    inicia_conexoes(servidores)

    recebe_linhas(servidores)
