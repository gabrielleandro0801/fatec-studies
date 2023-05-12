import threading
import socket
import time

HOST = '127.0.0.1'
PORT_SERVIDOR_A = 5000
PORT_CONTROLADOR_A = 5001

PORT_SERVIDOR_B = 5002
PORT_CONTROLADOR_B = 5003
QUANTIDADE_BYTES = 1024

PEDIDO = "0"
LIBERACAO = "1"

def executa_cliente_a():
    time.sleep(1)
    tcp_servidor_a = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    dest_servidor_a = (HOST, PORT_SERVIDOR_A)
    tcp_servidor_a.connect(dest_servidor_a)

    tcp_controlador_a = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    dest_controlador_a = (HOST, PORT_CONTROLADOR_A)
    tcp_controlador_a.connect(dest_controlador_a)
    
    while True:   
        a = 1
        b = 2
        x = str(a + b)
        time.sleep(1)
        tcp_controlador_a.send(PEDIDO.encode())
        time.sleep(1)
        resposta_controlador = "1" if tcp_controlador_a.recv(1024).decode() == "1" else "2"
        print("A | Resposta do controlador recebida")

        if resposta_controlador == "1":
            print("A | salvando x")
            tcp_servidor_a.send(x.encode())
            time.sleep(1)
            x_recebido = tcp_servidor_a.recv(1).decode()
            print("A | recebendo X")
            print(f"A | 1 + 2 = {x_recebido}")
            print("A | liberando servidor")
            tcp_controlador_a.send(LIBERACAO.encode())
        else:
            print("A | pedido negado - Servidor ocupado")


def executa_cliente_b():
    tcp_servidor_b = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    dest_servidor_b = (HOST, PORT_SERVIDOR_B)
    tcp_servidor_b.connect(dest_servidor_b)

    tcp_controlador_b = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    dest_controlador_b = (HOST, PORT_CONTROLADOR_B)
    tcp_controlador_b.connect(dest_controlador_b)

    while True:   
        a = 3
        b = 4
        x = str(a + b)
        time.sleep(1)
        tcp_controlador_b.send(PEDIDO.encode())
        time.sleep(1)
        resposta_controlador = "1" if tcp_controlador_b.recv(1024).decode() == "1" else "2"
        print("B | Resposta do controlador recebida")

        if resposta_controlador == "1":
            print("B | salvando x")
            tcp_servidor_b.send(x.encode())
            time.sleep(1)
            x_recebido = tcp_servidor_b.recv(1).decode()
            print("B | recebendo X")
            print(f"B | 3 + 4 = {x_recebido}")
            print("B | liberando servidor")
            tcp_controlador_b.send(LIBERACAO.encode())
        else:
            print("B | pedido - Servidor ocupado")


if __name__ == '__main__':
    t1 = threading.Thread(target=executa_cliente_a, args=())
    t2 = threading.Thread(target=executa_cliente_b, args=())

    t1.start()
    t2.start()

    t1.join()
    t2.join()