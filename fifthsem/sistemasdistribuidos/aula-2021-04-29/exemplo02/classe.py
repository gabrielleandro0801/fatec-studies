import Pyro5.api
# Dar o comando python3 -m Pyro5.nameserver antes


@Pyro5.api.expose
class OlaM(object):
    def mOlaM(self, nome):
        return f"{nome} Ola Mundo\n"


daemon = Pyro5.api.Daemon()
ns = Pyro5.api.locate_ns()
uri = daemon.register(OlaM)
ns.register("OlaMundo", uri)

daemon.requestLoop()
