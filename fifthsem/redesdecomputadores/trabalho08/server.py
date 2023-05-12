import socket

ETH_P_ALL = 3
ETH_FRAME_LEN = 1514

interface = 'wlp2s0'
s = socket.socket(socket.AF_PACKET, socket.SOCK_RAW, socket.htons(ETH_P_ALL))
s.bind((interface, 0))

data = s.recv(ETH_FRAME_LEN)
print(data)
s.close()
