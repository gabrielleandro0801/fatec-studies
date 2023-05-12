import Pyro5.api

uri = "PYRO:obj_0fd64cee804547ca9583fdcc6206b99e@localhost:46761"

o = Pyro5.api.Proxy(uri)
print(o.mOlaM("Gabriel Sousa"))
