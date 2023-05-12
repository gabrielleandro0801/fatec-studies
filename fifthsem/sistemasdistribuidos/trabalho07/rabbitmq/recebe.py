import os
import pika
from util import callback


class Recebe:
    def __init__(self):
        self.url = os.environ.get('CLOUDAMQP_URL', 'amqps://gozqoptb:T3AJ6rAR1RVN6w3469t9GrDiVN7zETq1@baboon.rmq.cloudamqp.com/gozqoptb')
        self.params = pika.URLParameters(self.url)
        self.connection = pika.BlockingConnection(self.params)
        self.channel = self.connection.channel()
        self.channel.queue_declare(queue='hello')

    def recebe(self):
        try:
            print('Aguardando mensagens...\n')
            self.channel.basic_consume('hello', callback, auto_ack=True)
            self.channel.start_consuming()
            self.connection.close()
        except Exception as e:
            raise e


if __name__ == '__main__':
    recebe = Recebe()
    recebe.recebe()
