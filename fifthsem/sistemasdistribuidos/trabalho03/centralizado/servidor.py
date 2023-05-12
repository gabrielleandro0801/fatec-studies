import socket
import time
import threading

HOST = '127.0.0.1'
PORT_CLIENTE_A = 5000
PORT_CLIENTE_B = 5002
QUANTIDADE_BYTES = 1024

global x
x = ''

def executa_servidor_a():
    global x

    # Cliente A
    tcp_a = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    orig_a = (HOST, PORT_CLIENTE_A)
    tcp_a.bind(orig_a)
    tcp_a.listen(1)
    con_a, cliente = tcp_a.accept()

    while True:
        time.sleep(3)
        x = con_a.recv(1024).decode()
        print(f"x salvo pelo A - x = {x}")
        con_a.send(x.encode())
        print("x devolvido para o A")


def executa_servidor_b():
    global x

    # Cliente B
    tcp_b = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    orig_b = (HOST, PORT_CLIENTE_B)
    tcp_b.bind(orig_b)
    tcp_b.listen(1)
    con_b, cliente = tcp_b.accept()

    while True:
        time.sleep(3)
        x = con_b.recv(1024).decode()
        print(f"x salvo pelo B - x = {x}")
        con_b.send(x.encode())
        print("x devolvido para o B")


if __name__ == '__main__':
    t1 = threading.Thread(target=executa_servidor_a, args=())
    t2 = threading.Thread(target=executa_servidor_b, args=())

    t1.start()
    t2.start()

    t1.join()
    t2.join()