import math

PORTA = "/dev/pts/"

SOH = b'\x01'
ACK = b'\x06'
NAK = b'\x15'
CAN = b'\x18'
EOT = b'\x04'

def checa_tamanho_arquivo(caminho_arquivo):
    arquivo = open(caminho_arquivo, 'r', encoding='ASCII') 
    conteudo_arquivo = arquivo.read()

    quantidade_bytes = len(conteudo_arquivo)
    quantidade_pacotes = math.floor((quantidade_bytes / 128) + 1)

    return quantidade_pacotes

def preenche_conteudo(conteudo):
    quantidade_restante = 128 - len(conteudo)

    caracteres = ''
    for i in range(quantidade_restante):
        caracteres += "*"
        

    return conteudo + caracteres

def complemento_numero_pacote(numero_pacote):
    complemento = ~numero_pacote

    retorno_complemento = bytes([complemento & 0xff])
    return retorno_complemento

def calcula_checksum(conteudo):
    checksum = 0
    for caractere in conteudo:
        checksum += ord(caractere)

    return bytes([checksum & 0xff])

def complemento_numero_pacote_bytes(numero_pacote):
    numero_int = int.from_bytes(numero_pacote, byteorder='big')

    complemento = ~numero_int
    retorno_complemento = bytes([complemento & 0xff])
    return retorno_complemento