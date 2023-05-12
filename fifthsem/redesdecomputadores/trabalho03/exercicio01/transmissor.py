import os
import serial

def envia_arquivo(porta, caminho_arquivo):
    tx = serial.Serial(porta)
    
    #abrindo o arquivo
    arquivo = open(caminho_arquivo, 'r', encoding='ASCII')    
    conteudo_arquivo = arquivo.read()

    #enviando o nome do arquivo
    nome_arquivo = (os.path.split(arquivo.name)[1]+'\n')
    tx.write(nome_arquivo.encode())    
    
    #enviando a quantidade de bytes do arquivo 
    quantidade_bytes = str(len(conteudo_arquivo)) + '\n'
    tx.write(quantidade_bytes.encode())

    #enviando o conteudo do arquivo
    tx.write(conteudo_arquivo.encode())

    #recebendo confirmacao
    resposta_receptor = tx.readline().decode().replace('\n', '')
    
    if resposta_receptor == 'Processo do Receptor finalizado':
        print('Processo do Transmissor finalizado')


if __name__ == '__main__':
    porta = input('Informe a porta para o Tx: ')
    caminho_arquivo = input("Informe o caminho completo do arquivo: ")
    envia_arquivo(porta, caminho_arquivo)