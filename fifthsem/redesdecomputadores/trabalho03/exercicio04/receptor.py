import os
import serial

def recebe_arquivos(porta: str):
    rx = serial.Serial(porta)

    quantidade_contas = int(rx.readline().decode().replace('\n', ''))

    for i in range(quantidade_contas):
        valor_um = float(rx.readline().decode().replace('\n', ''))
        operacao = rx.readline().decode().replace('\n', '')
        valor_dois = float(rx.readline().decode().replace('\n', ''))

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
        print('Resultado da operacao {:.2f} {} {:.2f} encaminhado ao Tx!' .format(valor_um, operacao, valor_dois))

    rx.write("Processo do Receptor finalizado\n".encode())
    print("Processo do Receptor finalizado")

if __name__ == '__main__':
    porta = input('Informe a porta para o Rx: ')
    recebe_arquivos(porta)
