import os
import serial


def envia_mensagem(porta, mensagem, destino):
    tx = serial.Serial('/dev/pts/' + porta)
    
    mensagem = destino + "|" + mensagem 
    quantidade_bytes = str(len(mensagem)) + '\n'

    tx.write(quantidade_bytes.encode())
    tx.write(mensagem.encode())


def recebe_mensagem(porta2):
    rx = serial.Serial('/dev/pts/' + porta2)

    quantidade_bytes = int(rx.readline().decode().replace('\n', ''))
    mensagem_recebida = rx.read(quantidade_bytes).decode()

    if mensagem_recebida[0] == 'c':
        print(f'Mensagem recebida: {mensagem_recebida[2:]}')
    else:
        print('O computador C nao e o destino!')
        porta_tx = input('Informe a porta para o tx do computador C: ')
        tx = serial.Serial('/dev/pts/' + porta_tx)

        quantidade_bytes = str(len(mensagem_recebida)) + '\n'
        tx.write(quantidade_bytes.encode())

        tx.write(mensagem_recebida.encode())
        print('Mensagem encaminhada')


if __name__ == '__main__':
    opcao = input('Insira a opcao para este computador:\nR - receber\nT - transmitir\nSua opcao: ').lower()

    if opcao == 't':
        porta_tx = input('Informe a porta para o tx: ')
        mensagem = input('Insira a mensagem a ser encaminhada: ')
        destino = input('Insira o computador a ser enviado [A | B | D]: ').lower()
        envia_mensagem(porta_tx, mensagem, destino)

    elif opcao == 'r':
        porta_rx = input('Informe a porta para o rx: ')
        recebe_mensagem(porta_rx)     
