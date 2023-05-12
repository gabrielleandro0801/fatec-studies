import socket

HOST = '127.0.0.1'
PORT = 5000
QUANTIDADE_BYTES = 1024


def servidor():
    tcp = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    orig = (HOST, PORT)
    tcp.bind(orig)
    tcp.listen(1)
    con, cliente = tcp.accept()

    mensagem = con.recv(QUANTIDADE_BYTES).decode()

    array = mensagem.split(';')
    op1 = float(array[0])
    op2 = float(array[1])
    operacao = array[2]

    resultado = 0
    if operacao == '+':
        resultado = op1 + op2
    elif operacao == '-':
        resultado = op1 - op2
    elif operacao == '*':
        resultado = op1 * op2
    elif operacao == '/':
        if op2 == 0:
            print('Impossivel dividir por zero. Valor padrao retornado')
        else:
            resultado = op1 / op2
    else: 
        print('Operacao invalida! Valor padrao retornado')

    con.send(str(resultado).encode())
    print('Resultado encaminhado ao cliente.')
    exit()


if __name__ == '__main__':
    servidor()
