import serial

def envia_valores(porta):
    tx = serial.Serial(porta)

    #enviando primeiro valor
    valor_um = input('Informe o primeiro valor: ')
    tx.write((valor_um + "\n").encode())

    #enviando segundo valor
    valor_dois = input('Informe o segundo valor: ')
    tx.write((valor_dois + "\n").encode())

    #enviando operacao
    operacao = input('Informe a operacao (+ - * /): ')
    tx.write((operacao + "\n").encode())

    #recebendo resultado
    resultado = tx.readline().decode()
    print('O resultado da operacao e: {}' .format(resultado))


if __name__ == '__main__':
    porta_tx = input('Informe a porta para o TX: ')
    envia_valores(porta_tx)