import Pyro5.api
# Dar o comando python3 -m Pyro5.nameserver antes


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
ns = Pyro5.api.locate_ns()
uri = daemon.register(Matematica)
ns.register("Matematica", uri)

daemon.requestLoop()
