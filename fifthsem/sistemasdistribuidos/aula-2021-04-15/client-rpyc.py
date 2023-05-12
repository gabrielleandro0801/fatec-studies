import rpyc

c = rpyc.connect("localhost", 18861)

a = 1
b = 2
print(c.root.soma(a, b))
