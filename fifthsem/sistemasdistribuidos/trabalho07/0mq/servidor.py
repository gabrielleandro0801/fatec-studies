import zmq


class Server:
    def __init__(self):
        self.context = zmq.Context()
        self.socket = self.context.socket(zmq.REP)
        self.socket.bind("tcp://*:5555")

    def receive_initial_message(self):
        message = self.socket.recv().decode()
        print(f">>> Mensagem do cliente: {message}")
        self.socket.send(b"Conexao estabelecida, aguardando envios")

    def receive_messages(self):
        for i in range(7):
            message = self.socket.recv().decode()
            self.socket.send(b"Prato recebido com sucesso")
            print(f">>> Mensagem recebida: {message}")

        print(">>> Cardapio recebido com sucesso!")
        print(f">>> Encerramento: {self.socket.recv().decode()}")
        self.socket.send(b"Encerrando conversa")


if __name__ == '__main__':
    server = Server()
    server.receive_initial_message()
    server.receive_messages()
