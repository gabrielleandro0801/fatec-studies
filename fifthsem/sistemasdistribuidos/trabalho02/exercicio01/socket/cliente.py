import socket

HOST = '127.0.0.1'
PORT = 5000
QUANTIDADE_BYTES = 1024


def cliente(op1, op2, operacao):
    tcp = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    dest = (HOST, PORT)
    tcp.connect(dest)

    tcp.send(str(op1).encode())
    tcp.send(';'.encode())
    tcp.send(str(op2).encode())
    tcp.send(';'.encode())
    tcp.send(operacao.encode())
    tcp.send(';'.encode())

    resultado = float(tcp.recv(QUANTIDADE_BYTES).decode())
    print('Resultado retornado do servidor da operacao: {} {} {} = {}' 
        .format(op1, operacao, op2, resultado))
    exit()


if __name__ == '__main__':
    op1 = input('Informe o primeiro operando: ')
    operacao = input('Informe a operacao: ')
    op2 = input('Informe o segundo operando: ')
    cliente(op1, op2, operacao)
