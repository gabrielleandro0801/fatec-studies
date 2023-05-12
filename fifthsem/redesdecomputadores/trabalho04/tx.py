import serial
import util


def envia_arquivo(porta, caminho_arquivo):
    tx = serial.Serial(porta)
    print(f'Tx conectado na porta: {porta}')

    if tx.read(1) != util.NAK:
        raise Exception('NAK nao foi recebido com sucesso')
    print('\nNAK recebido com sucesso')

    quantidade_pacotes = util.checa_tamanho_arquivo(caminho_arquivo)
    print(f'Quantidade de pacotes necessarios: {quantidade_pacotes}\n')

    print('Iniciando envio do arquivo...\n')
    arquivo = open(caminho_arquivo, 'r', encoding='ASCII') 
    for pacote in range(0, quantidade_pacotes):
        conteudo = arquivo.read(128)

        conteudo = util.preenche_conteudo(conteudo)

        tx.write(util.SOH)
        print(f'SOH: {util.SOH}')

        num_pacote = pacote + 1
        tx.write(bytes([num_pacote & 0xff]))
        print(f'Pacote: {num_pacote}')

        tx.write(util.complemento_numero_pacote(num_pacote))
        print(f'Complemento: {util.complemento_numero_pacote(num_pacote)}')

        tx.write(conteudo.encode())

        tx.write(util.calcula_checksum(conteudo))
        print(f'Checksum: {util.calcula_checksum(conteudo)}\n')

        resposta = tx.read(1)

        if resposta in [util.CAN, util.NAK]:
            print(f'Resposta do Rx foi CAN ou NAK - cancelando envio')
            break

    tx.write(util.EOT)

    confimacao_termino = tx.read(1)
    if confimacao_termino == util.NAK:
        tx.write(util.EOT)
        print('Transferencia finalizada com sucesso!')


if __name__ == '__main__':
    porta = input('Porta para o Tx: ')
    porta = util.PORTA + porta

    caminho_arquivo = "/home/gabriel/arquivo.txt"
    envia_arquivo(porta, caminho_arquivo)
    