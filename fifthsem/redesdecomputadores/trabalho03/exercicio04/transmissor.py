import os
import serial

def retira_quebra_linha(valor):
    return valor.replace('\n', '')

def envia_arquivos(porta, quantidade_contas):
    tx = serial.Serial(porta)

    quantidade_contas_string = str(quantidade_contas) + '\n'
    tx.write(quantidade_contas_string.encode())

    valores_um = []
    valores_dois = []
    operacoes = []    

    for i in range(quantidade_contas):
        print("{}a operacao: " .format(i+1))
        valor_um = float(input('Informe o valor do primeiro operando: '))
        valores_um.append(str(valor_um) + '\n')

        operacao = input('Informe a operacao : ')
        operacoes.append(operacao + '\n')

        valor_dois = float(input('Informe o valor do segundo operando: '))
        valores_dois.append(str(valor_dois) + '\n')

    for i in range(quantidade_contas):
        tx.write(valores_um[i].encode())
        tx.write(operacoes[i].encode())
        tx.write(valores_dois[i].encode())

        resposta = float(tx.readline().decode().replace('\n', ''))
        print("Resposta: " + retira_quebra_linha(valores_um[i]) + " " + retira_quebra_linha(operacoes[i]) + " " + retira_quebra_linha(valores_dois[i]) + " = {:.2f}" .format(resposta))

    resposta_receptor = tx.readline().decode().replace('\n', '')
    
    if resposta_receptor == 'Processo do Receptor finalizado':
        print('Processo do Transmissor finalizado')

if __name__ == '__main__':
    porta = input('Informe a porta para o Tx: ')
    quantidade_contas = int(input("Insira a quantidade operacoes matematicas a serem realizadas: "))
    envia_arquivos(porta, quantidade_contas)