import zmq

context = zmq.Context()
socket = context.socket(zmq.REQ)
socket.connect("tcp://localhost:5555")
socket.send(b"Ola mundo")
message = socket.recv()
print(message)