import zmq

context = zmq.Context()
socket = context.socket(zmq.REP)
socket.bind("tcp://*:5555")

message = socket.recv()
print(message)
socket.send(b"Ola")

while True:
    message = socket.recv()
    print(message)
    socket.send(b"Ola")