import serial
import util


def recebe_arquivo(porta, arquivo_destino):
    rx = serial.Serial(porta)
    print(f'Rx conectado na porta: {porta}')

    # Iniciando transferencia
    rx.write(util.NAK)
    print('\nEnviando NAK para o Tx\n')

    recepcao = rx.read(1) # EOT ou SOH
    while recepcao != util.EOT:
        numero_pacote = rx.read(1)
        print(f'Numero do pacote: {numero_pacote}')

        complemento_numero_pacote = rx.read(1)
        complemento_numero_pacote_calculado = util.complemento_numero_pacote_bytes(numero_pacote)
        print(f'Complemento do num do pacote: {complemento_numero_pacote} | Complemento calculado: {complemento_numero_pacote_calculado}')
        
        conteudo = rx.read(128)
        
        checksum_recebido = rx.read(1)
        checksum_calculado = util.calcula_checksum(conteudo.decode())
        print(f'Checksum recebido: {checksum_recebido} | Checksum calculado: {checksum_calculado}\n')

        if complemento_numero_pacote_calculado != complemento_numero_pacote:
            rx.write(util.CAN)

        if checksum_calculado != checksum_recebido:
            rx.write(util.NAK)

        arquivo = open(arquivo_destino, 'a', encoding='ASCII')
        arquivo.write(conteudo.decode())
        rx.write(util.ACK)

        recepcao = rx.read(1)

    rx.write(util.NAK)

    confirmacao_termino = rx.read(1)
    if confirmacao_termino == util.EOT:
        rx.write(util.ACK)
        print('Transferencia finalizada com sucesso!')

    
if __name__ == '__main__':
    porta = input('Porta para o Rx: ')
    porta = util.PORTA + porta

    arquivo_destino = "/home/gabriel/copia.txt"
    recebe_arquivo(porta, arquivo_destino)