import os
import serial

def envia_arquivos(porta, quantidade_arquivos):
    tx = serial.Serial(porta)

    caminhos = []
    nomes_arquivos = []
    quantidade_bytes = []
    conteudos = []

    quantidade_arquivos_string = str(quantidade_arquivos) + '\n'
    tx.write(quantidade_arquivos_string.encode())

    for i in range(quantidade_arquivos):
        caminho = input('Informe o caminho do {}o arquivo: ' .format(i+1))
        caminhos.append(caminho)

    for caminho in caminhos:
        arquivo = open(caminho, 'r', encoding='ASCII')
        
        nome_arquivo = (os.path.split(arquivo.name)[1]+'\n')
        nomes_arquivos.append(nome_arquivo)

        conteudo = arquivo.read()
        conteudos.append(conteudo)

        quantidade_byte = str(len(conteudo)) + '\n'
        quantidade_bytes.append(quantidade_byte)

    for i in range(quantidade_arquivos):
        tx.write(nomes_arquivos[i].encode())
        tx.write(quantidade_bytes[i].encode())
        tx.write(conteudos[i].encode())

        confirmacao = tx.readline().decode().replace('\n', '')
        print('Arquivo ' + nomes_arquivos[i].replace('\n', '') + ' enviado com sucesso!')

    resposta_receptor = tx.readline().decode().replace('\n', '')
    
    if resposta_receptor == 'Processo do Receptor finalizado':
        print('Processo do Transmissor finalizado')

if __name__ == '__main__':
    porta = input('Informe a porta para o Tx: ')
    quantidade_arquivos = int(input("Insira a quantidade de arquivos a serem encaminhados: "))
    envia_arquivos(porta, quantidade_arquivos)