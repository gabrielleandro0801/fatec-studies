import Pyro5.api


@Pyro5.api.expose
class OlaM(object):
    def mOlaM(self, nome):
        return f"{nome} Ola Mundo\n"
        

daemon = Pyro5.api.Daemon()
uri = daemon.register(OlaM)
print(f"Ready. Object uri = {uri}")
daemon.requestLoop()
