import threading
import socket
import time
from random import randint

HOST = '127.0.0.1'
PORT_SERVIDOR = 5000
PORT_PEDIDO_PRO_B = 5001
PORT_PEDIDO_DO_B = 5003
QUANTIDADE_BYTES = 1024

global aberto 
aberto = 0


def executa_cliente_a():
    global aberto
    tcp_servidor = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    dest_servidor = (HOST, PORT_SERVIDOR)
    tcp_servidor.connect(dest_servidor)

    tcp_cliente_b = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    dest_cliente_b = (HOST, PORT_PEDIDO_PRO_B)
    tcp_cliente_b.connect(dest_cliente_b)
    
    while True:   
        a = 1
        b = 2
        x = str(a + b)

        time.sleep(1)
        tcp_cliente_b.send("0".encode())
        time.sleep(1)

        resposta_cliente_b = 0 if tcp_cliente_b.recv(1024).decode() == "liberada" else 1
        print("A | Resposta do cliente B recebida")

        if resposta_cliente_b == 0:
            aberto = 1
            print("A | bloqueando acesso")
            tcp_servidor.send(x.encode())

            time.sleep(1)
            x_recebido = tcp_servidor.recv(1).decode()
            print("A | recebendo X do servidor")
            print(f"A | 1 + 2 = {x_recebido}")
            print("A | liberando servidor pro B")
            aberto = 0
        else:
            print("A | Pedido [negado] - Servidor ocupado pelo B")


def escuta_cliente_b():
    global aberto

    tcp_a = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    orig_a = (HOST, PORT_PEDIDO_DO_B)
    tcp_a.bind(orig_a)
    tcp_a.listen(1)
    con_a, cliente = tcp_a.accept()

    while True:
        time.sleep(randint(1,3))
        x = con_a.recv(1024).decode()
        print("> | Pedido do B recebido")
        permissao = "liberada" if aberto == 0 else "negada" 
        con_a.send(permissao.encode())
        print(f"> | Resposta [{permissao}] devolvida para o B")


if __name__ == '__main__':
    t1 = threading.Thread(target=executa_cliente_a, args=())
    t2 = threading.Thread(target=escuta_cliente_b, args=())

    t1.start()
    t2.start()

    t1.join()
    t2.join()
