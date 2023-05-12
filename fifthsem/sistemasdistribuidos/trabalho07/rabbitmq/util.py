def callback(ch, method, properties, body):
    imprime_mensagem(body)


def imprime_mensagem(msg):
    print(f">>> Mensagem recebida: [{msg.decode()}]")
    return
