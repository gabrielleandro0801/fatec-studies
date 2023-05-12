import socket

ETH_P_ALL = 3

interface = 'wlp2s0'

src = b'\x98\x83\x89\xd2\x59\xab'
dst = b'\x98\x83\x89\xd2\x59\xab'
proto = b'\x88\xb5'

message = 'Grupo8 | Gabriel | Luiz | Matheus'
payload = message.encode()

s = socket.socket(socket.AF_PACKET, socket.SOCK_RAW, socket.htons(ETH_P_ALL))
s.bind((interface, 0))
s.sendall(dst + src + proto + payload)
s.close()
