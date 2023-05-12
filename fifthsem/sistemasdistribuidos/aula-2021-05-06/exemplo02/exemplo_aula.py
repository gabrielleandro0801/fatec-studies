import pika
# localhost:15672


def callback(ch, method, properties, body):
    print(" [x] Received %r" % body)


# Iniciando conexão e declarando fila
connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))
channel = connection.channel()
channel.queue_declare(queue='Ola')

# Publicando mensagem e fechando conexão
channel.basic_publish(exchange='', routing_key='Ola', body='Ola Mundo')
connection.close()

# Iniciando nova conexão e declarando fila novamente
connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))
channel = connection.channel()
channel.queue_declare(queue='Ola')

# Consumindo mensagem da fila
channel.basic_consume(queue='Ola', auto_ack=True, on_message_callback=callback)
