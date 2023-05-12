import threading
import socket
import time
from random import randint

HOST = '127.0.0.1'
PORT_SERVIDOR = 5002
PORT_PEDIDO_PRO_A = 5003
PORT_PEDIDO_DO_A = 5001
QUANTIDADE_BYTES = 1024

global aberto 
aberto = 0


def executa_cliente_b():
    global aberto
    tcp_servidor = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    dest_servidor = (HOST, PORT_SERVIDOR)
    tcp_servidor.connect(dest_servidor)

    time.sleep(1)
    tcp_cliente_a = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    dest_cliente_a = (HOST, PORT_PEDIDO_PRO_A)
    tcp_cliente_a.connect(dest_cliente_a)
    
    while True:   
        a = 3
        b = 4
        x = str(a + b)

        time.sleep(1)
        tcp_cliente_a.send("0".encode())
        time.sleep(1)

        resposta_cliente_b = 0 if tcp_cliente_a.recv(1024).decode() == "liberada" else 1
        print("B | Resposta do cliente A recebida")

        if resposta_cliente_b == 0:
            aberto = 1
            print("B | bloqueando acesso")

            tcp_servidor.send(x.encode())
            time.sleep(1)
            x_recebido = tcp_servidor.recv(1).decode()
            print("B | recebendo X")
            print(f"B | 3 + 4 = {x_recebido}")
            print("B | liberando servidor pro A")
            aberto = 0
        else:
            print("B | Pedido [negado] - Servidor ocupado pelo A")


def escuta_cliente_a():
    global aberto

    tcp_b = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    orig_b = (HOST, PORT_PEDIDO_DO_A)
    tcp_b.bind(orig_b)
    tcp_b.listen(1)
    con_b, cliente = tcp_b.accept()

    while True:
        time.sleep(randint(1,3))
        x = con_b.recv(1024).decode()
        print("> | Pedido do A recebido")
        permissao = "liberada" if aberto == 0 else "negada" 
        con_b.send(permissao.encode())
        print(f"> | Resposta [{permissao}] devolvida para o A")


if __name__ == '__main__':
    t1 = threading.Thread(target=executa_cliente_b, args=())
    t2 = threading.Thread(target=escuta_cliente_a, args=())

    t1.start()
    t2.start()

    t1.join()
    t2.join()
