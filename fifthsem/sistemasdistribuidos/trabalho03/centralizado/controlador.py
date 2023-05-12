import socket
import time
import threading

HOST = '127.0.0.1'
PORT_CLIENTE_A = 5001
PORT_CLIENTE_B = 5003
QUANTIDADE_BYTES = 1024

global aberto
aberto = 0

def executa_controlador_a():
    global aberto

    # Cliente A
    tcp_a = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    orig_a = (HOST, PORT_CLIENTE_A)
    tcp_a.bind(orig_a)
    tcp_a.listen(1)
    con_a, cliente = tcp_a.accept()

    while True:
        time.sleep(3)
        pedido_a = con_a.recv(1024).decode()
        print(f"Pedido A recebido | Aberto: {aberto}")

        if aberto == 0:
            con_a.send("1".encode())
            aberto = 1
            print(f"A | bloqueando servidor")
            time.sleep(1)
            resposta_a = con_a.recv(1024).decode()
            aberto = 0
            print(f"A | liberando servidor")
        else:
            con_a.send("2".encode())
            print("A | pedido negado - Servidor ocupado")


def executa_controlador_b():
    global aberto

    # Cliente B
    tcp_b = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    orig_b = (HOST, PORT_CLIENTE_B)
    tcp_b.bind(orig_b)
    tcp_b.listen(1)
    con_b, cliente = tcp_b.accept()

    while True:
        time.sleep(3)
        pedido_b = con_b.recv(1024).decode()
        print(f"Pedido B recebido | Aberto: {aberto}")

        if aberto == 0:
            con_b.send("1".encode())
            aberto = 1
            print(f"B | bloqueando servidor")
            time.sleep(1)
            resposta_b = con_b.recv(1024).decode()
            aberto = 0
            print(f"B | liberando servidor")
        else:
            con_b.send("2".encode())
            print("B | pedido negado - Servidor ocupado")


if __name__ == '__main__':
    t1 = threading.Thread(target=executa_controlador_a, args=())
    t2 = threading.Thread(target=executa_controlador_b, args=())

    t1.start()
    t2.start()

    t1.join()
    t2.join()