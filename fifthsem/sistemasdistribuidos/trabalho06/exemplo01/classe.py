import Pyro5.api


@Pyro5.api.expose
class Matematica(object):
    def soma(self, a, b):
        return a + b

    def subtrai(self, a, b):
        return a - b

    def multiplica(self, a, b):
        return a * b

    def divide(self, a, b):
        return a / b

    def potencia(self, a, b):
        return a ** b


daemon = Pyro5.api.Daemon()
uri = daemon.register(Matematica)
print(f"Ready. Object uri = {uri}")
daemon.requestLoop()
