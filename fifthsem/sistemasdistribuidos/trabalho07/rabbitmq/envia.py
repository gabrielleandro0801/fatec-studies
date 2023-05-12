import os
import pika


class Envia:
    def __init__(self):
        self.url = os.environ.get('CLOUDAMQP_URL', 'amqps://gozqoptb:T3AJ6rAR1RVN6w3469t9GrDiVN7zETq1@baboon.rmq.cloudamqp.com/gozqoptb')
        self.params = pika.URLParameters(self.url)
        self.connection = pika.BlockingConnection(self.params)
        self.channel = self.connection.channel()
        self.channel.queue_declare(queue='hello')

    def envia(self):
        try:
            while True:
                opcao = int(input('Insira sua opcao:\n1 - Enviar mensagem\n2 - Sair\nSua opcao: '))

                if opcao == 1:
                    mensagem = input('Insira sua mensagem: ')
                    self.channel.basic_publish(exchange='', routing_key='hello', body=mensagem)
                    print(f">>> Mensagem enviada: [{mensagem}]\n")
                else:
                    break

        except Exception as e:
            raise e
        finally:
            self.connection.close()


if __name__ == '__main__':
    envia = Envia()
    envia.envia()
