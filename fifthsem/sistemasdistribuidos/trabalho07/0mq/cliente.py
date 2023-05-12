import zmq


class Client:
    def __init__(self):
        self.context = zmq.Context()
        self.socket = self.context.socket(zmq.REQ)
        self.socket.connect("tcp://localhost:5555")

    def send_initial_message(self):
        self.socket.send(b"Ola, servidor! Iniciando conexao")
        message = self.socket.recv().decode()
        print(f">>> Resposta do servidor: {message}")

    def send_messages(self):
        print(">>> Enviando lista dos pratos do restaurante: ")

        self.socket.send(b"\xf0\x9f\x8d\x97 | Segunda-feira: R$ 18,00")
        print(f">>> Resposta do servidor: {self.socket.recv().decode()}")

        self.socket.send(b"\xf0\x9f\x8d\x94 | Terca-feira: R$ 34,00")
        print(f">>> Resposta do servidor: {self.socket.recv().decode()}")

        self.socket.send(b"\xf0\x9f\x8c\xad | Quarta-feira: R$ 7,00")
        print(f">>> Resposta do servidor: {self.socket.recv().decode()}")

        self.socket.send(b"\xf0\x9f\x8d\xb3 | Quinta-feira: R$ 10,00")
        print(f">>> Resposta do servidor: {self.socket.recv().decode()}")

        self.socket.send(b"\xf0\x9f\xa5\x97 | Sexta-feira: R$ 15,00")
        print(f">>> Resposta do servidor: {self.socket.recv().decode()}")

        self.socket.send(b"\xf0\x9f\x8d\x95 | Sabado: R$ 25,00")
        print(f">>> Resposta do servidor: {self.socket.recv().decode()}")

        self.socket.send(b"\xf0\x9f\xa7\x87 | Domingo: R$ 34,00")
        print(f">>> Resposta do servidor: {self.socket.recv().decode()}")

        self.socket.send(b"Cardapio encerrado! \xf0\x9f\x98\x80")
        print(f">>> Resposta final do servidor: {self.socket.recv().decode()}")


if __name__ == '__main__':
    client = Client()
    client.send_initial_message()
    client.send_messages()
