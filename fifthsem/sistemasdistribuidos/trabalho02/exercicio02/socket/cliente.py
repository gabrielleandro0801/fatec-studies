import socket
from random import randint
from socket import AF_INET, SOCK_STREAM
import time


HOST = '127.0.0.1'
PORTA_BASE = 5000
QUANTIDADE_BYTES = 1024


def cria_matriz(linhas, colunas):
    matriz = []

    for i in range(linhas):
        linha = []

        for j in range(colunas):
            linha.append(randint(0,9))
        matriz.append(linha)
    
    return matriz


def imprime_matriz(nome, matriz):
    print('\nMatriz ' + nome + ":")
    for linha in matriz:
        print(linha)


def cria_conexoes(linhas):
    global PORTA_BASE

    clientes = []
    for i in range(linhas):
        cliente = {
            'tcp': socket.socket(family=AF_INET, type=SOCK_STREAM),
            'porta': PORTA_BASE + (i+1)
        }

        clientes.append(cliente)
    return clientes


def inicia_conexoes(clientes):
    for i in range(len(clientes)):
        print(f"Aguardando conexao {i+1}...")
        time.sleep(2)
        clientes[i]['tcp'].connect((HOST, clientes[i]['porta']))
        print(f"Conexao {i+1} realizada")


def prepara_linhas(linha_a, linha_b):
    linha = ''
    for i in range(len(linha_a)):
        linha += str(linha_a[i]) + ";" + str(linha_b[i]) + ";"

    return linha


def monta_linhas(matriz_a, matriz_b):
    linhas = []
    for i in range(len(matriz_a)):
        linha = prepara_linhas(matriz_a[i], matriz_b[i])
        linhas.append(linha)

    return linhas


def envia_linhas(clientes, linhas):
    linhas_resultado = []
    for i in range(len(linhas)):
        clientes[i]['tcp'].send(linhas[i].encode())
        time.sleep(1)
        linha = clientes[i]['tcp'].recv(QUANTIDADE_BYTES).decode()
        linha = linha[:-1]
        linhas_resultado.append(linha)

    return linhas_resultado


def converte_linhas_em_matriz(linhas):
    matriz_resultado = []

    for linha in linhas:
        valores = linha.split(';')
        linha_matriz = []
        for valor in valores:
            linha_matriz.append(int(valor))
        matriz_resultado.append(linha_matriz)
    
    return matriz_resultado


if __name__ == '__main__':
    linhas = int(input('Insira a quantidade de linhas: '))
    colunas = int(input('Insira a quantidade de colunas: '))

    matriz_a = cria_matriz(linhas, colunas)
    matriz_b = cria_matriz(linhas, colunas)

    imprime_matriz("A", matriz_a)
    imprime_matriz("B", matriz_b)

    cliente_pai = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    cliente_pai.connect((HOST, PORTA_BASE))
    cliente_pai.send(str(linhas).encode())
    print('\nCliente pai conectado\n')

    clientes = cria_conexoes(linhas)
    inicia_conexoes(clientes)
    
    linhas = monta_linhas(matriz_a, matriz_b)
    linhas_resultado = envia_linhas(clientes, linhas)

    matriz_resultado = converte_linhas_em_matriz(linhas_resultado)
    imprime_matriz("Resultado", matriz_resultado)
