import socket

HOST = '127.0.0.1'
PORT = 5000

tcp = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
orig = (HOST, PORT)
tcp.bind(orig)
tcp.listen(1)
con, cliente = tcp.accept()

msg = con.recv(3)
print(msg.decode())

msg = con.recv(1024)
print(msg.decode())

m = msg.decode()
l = m.split(';')
sa = l[0]
sb = l[1]
op = l[2]

if op == '+':
   x = sa+sb

a = float(sa)
b = float(sb)

if op == '+':
   x = a + b

print(x)
con.send(str(x).encode())
exit()