import os
import serial

def recebe_arquivo(porta: str):
    rx = serial.Serial(porta)

    #recebendo o nome do arquivo
    nome_arquivo = rx.readline().decode().replace('\n', '')

    #recebendo a quantidade de bytes do arquivo
    quantidade_bytes = int(rx.readline().decode().replace('\n', ''))

    #recebendo o conteudo do arquivo
    conteudo = rx.read(quantidade_bytes).decode()

    #imprimindo valores
    print("Nome do arquivo: ")
    print(nome_arquivo)
    print("\nConteudo do arquivo: ")
    print(conteudo)    
    
    caminho_destino = '/home/gabriel/ex1/' + nome_arquivo
    arquivo = open(caminho_destino, 'w', encoding='ASCII')
    arquivo.write(conteudo)
    print('Arquivo copiado no caminho: {}' .format(caminho_destino))
    
    #enviando confirmacao
    rx.write("Processo do Receptor finalizado\n".encode())
    print("Processo do Receptor finalizado")

if __name__ == '__main__':
    porta = input('Informe a porta para o Rx: ')
    recebe_arquivo(porta)