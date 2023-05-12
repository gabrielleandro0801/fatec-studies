import threading
from random import randint

global matriz_a
matriz_a = []
global matriz_b
matriz_b = []
global matriz_resultado 
matriz_resultado = []

def imprime_matriz(nome, matriz):
    print('\nMatriz ' + nome + ":")
    for linha in matriz:
        print(linha)


def cria_matriz(linhas, colunas):
    matriz = []

    for i in range(linhas):
        linha = []

        for j in range(colunas):
            linha.append(randint(0,9))
        matriz.append(linha)
    
    return matriz


def soma_linhas(linha_a, linha_b, qtd_colunas):
    linha_resultado = []
    
    for i in range(qtd_colunas):
        resultado = linha_a[i] + linha_b[i]
        linha_resultado.append(resultado)
    matriz_resultado.append(linha_resultado)


if __name__ == '__main__':
    linhas = int(input('Insira a quantidade de linhas: '))
    colunas = int(input('Insira a quantidade de colunas: '))
    
    matriz_a = cria_matriz(linhas, colunas)
    matriz_b = cria_matriz(linhas, colunas)

    imprime_matriz("A", matriz_a)
    imprime_matriz("B", matriz_b)
      
    for i in range(linhas):
        thread = threading.Thread(target=soma_linhas(matriz_a[i], matriz_b[i], colunas), args=())
        thread.start()
        thread.join()

    imprime_matriz("Resultado", matriz_resultado)
