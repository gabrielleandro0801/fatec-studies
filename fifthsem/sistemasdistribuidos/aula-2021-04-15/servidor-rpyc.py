import rpyc

class MyService(rpyc.Service):
	def exposed_soma(self, a, b):
		return a + b


s = rpyc.utils.server.ThreadedServer(MyService(), port=18861)
s.start()
