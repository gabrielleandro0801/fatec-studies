import threading

global resultado
resultado = 0
global op1
op1 = 0
global op2
op2 = 0

global operacao
operacao = ''

def faz_calculo():
    global op1, op2, resultado, operacao

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

if __name__ == '__main__':
    op1 = float(input('Informe o primeiro valor: '))
    operacao = input('Informe a operacao: ')
    op2 = float(input('Informe o segundo valor: '))
    
    t1 = threading.Thread(target=faz_calculo, args=())
    t1.start()  
    t1.join()

    print(f'Resultado da operacao {op1} {operacao} {op2} = {resultado}')