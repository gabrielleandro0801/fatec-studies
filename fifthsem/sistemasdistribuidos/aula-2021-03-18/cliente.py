import socket

PORT = 5000
HOST = '127.0.0.1'

tcp = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
dest = (HOST, PORT)
tcp.connect(dest)

a = 1
b = 2
op = '+'

tcp.send(str(a).encode())
tcp.send(str(b).encode())
tcp.send(op.encode())

tcp.send(str(a).encode())
tcp.send(';'.encode())
tcp.send(str(b).encode())
tcp.send(';'.encode())
tcp.send(op.encode())
tcp.send(';'.encode())

msg = tcp.recv(1024)
r = float(msg.decode())
print(r)
exit()