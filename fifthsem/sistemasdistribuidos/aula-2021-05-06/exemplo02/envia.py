import pika
# localhost:15672

# Iniciando conexão e declarando fila
connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))
channel = connection.channel()
channel.queue_declare(queue='Ola')

# Publicando mensagem e fechando conexão
channel.basic_publish(exchange='', routing_key='Ola', body='Ola Mundo')
print(" [x] Sent 'Ola Mundo'")
connection.close()
