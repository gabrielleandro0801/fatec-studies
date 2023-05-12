import Pyro5.api

o = Pyro5.api.Proxy("PYRONAME:OlaMundo")
print(o.mOlaM("Gabriel Leandro"))
