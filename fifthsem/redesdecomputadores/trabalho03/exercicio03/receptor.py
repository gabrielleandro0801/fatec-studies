import os
import serial

def recebe_arquivos(porta: str):
    rx = serial.Serial(porta)

    quantidade_arquivos = int(rx.readline().decode().replace('\n', ''))

    for i in range(quantidade_arquivos):
        nome_arquivo = rx.readline().decode().replace('\n', '')
        quantidade_bytes = int(rx.readline().decode().replace('\n', ''))
        conteudo_arquivo = rx.read(quantidade_bytes).decode()

        print("Nome do arquivo: ")
        print(nome_arquivo)
        print("\nConteudo do arquivo: ")
        print(conteudo_arquivo) 

        confirmacao = "Arquivo " + nome_arquivo + " recebido com sucesso\n" 
        rx.write(confirmacao.encode())

        caminho_destino = '/home/gabriel/ex3/' + nome_arquivo
        arquivo = open(caminho_destino, 'w', encoding='ASCII')
        arquivo.write(conteudo_arquivo)
        print('Arquivo copiado no caminho: {}' .format(caminho_destino))

        print("Confirmacao de recebimento enviada com sucesso!")

    rx.write("Processo do Receptor finalizado\n".encode())
    print("Processo do Receptor finalizado")

if __name__ == '__main__':
    porta = input('Informe a porta para o Rx: ')
    recebe_arquivos(porta)
