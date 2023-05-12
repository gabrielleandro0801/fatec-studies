import serial

def recebe_valores(porta):
    rx = serial.Serial(porta)

    print('Aguardando primeiro valor')
    valor_um = float(rx.readline().decode().replace('\n', ''))

    print('Aguardando segundo valor')
    valor_dois = float(rx.readline().decode().replace('\n', ''))
    
    print('Aguardando operacao')
    operacao = rx.readline().decode().replace('\n', '')

    resultado = 0
    if operacao == '+':
        resultado = valor_um + valor_dois;
    elif operacao == '-':
        resultado = valor_um - valor_dois;
    elif operacao == '*':
        resultado = valor_um * valor_dois;
    elif operacao == '/':
        resultado = valor_um / valor_dois;

    resultado_string = str(resultado) + "\n"
    rx.write(resultado_string.encode())
    
    print('Resultado encaminhado ao Tx!')


if __name__ == '__main__':
    porta_rx = input('Informe a porta para o RX: ')
    recebe_valores(porta_rx)