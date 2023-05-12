import threading
mutex = threading.Lock()

global imc
imc = 0

global peso_p1
peso_p1 = 68
global altura_p1
altura_p1 = 1.69
global peso_p2
peso_p2 = 93
global altura_p2
altura_p2 = 1.74

def funcao1():
    global imc, peso_p1, altura_p1
    while(True):
        peso = peso_p1
        altura = altura_p1

        mutex.acquire()
        imc = peso / (altura * altura)
        if imc > 24:
            print("Erro ao calcular IMC da pessoa 1")
        mutex.release()

def funcao2():
    global imc, peso_p2, altura_p2
    while(True):
        peso = peso_p2
        altura = altura_p2

        mutex.acquire()
        imc = peso / (altura * altura)
        if imc < 30:
            print("Erro ao calcular IMC da pessoa 2")
        mutex.release()

t1 = threading.Thread(target=funcao1)
t2 = threading.Thread(target=funcao2)
t1.start()
t2.start()
t1.join()
t2.join()