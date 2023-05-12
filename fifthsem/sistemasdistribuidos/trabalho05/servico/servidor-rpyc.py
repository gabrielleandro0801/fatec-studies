import rpyc
class MyService(rpyc.Service):
        def exposed_soma(self, a, b):
            return (a + b)
        
        def exposed_subtrai(self, a, b):
            return (a - b)

        def exposed_multiplica(self, a, b):
            return (a * b)
        
        def exposed_divide(self, a, b):
            return a / b

        def exposed_potencia(self, a, b):
            return a ** b
        
        def exposed_imprime(self, resultado):
            return f"\n>>> Resultado da operacao: {resultado}\n"
            

s = rpyc.utils.server.ThreadedServer(MyService, port=18861)
s.start()
