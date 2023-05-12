global a
a = 0
global b
b = 0
global c
c = 0
global d
d = 0
global X
X = 0

def funcao1():
   global a, b, c, X
   a = 1
   b = 2
   X = a + b
   print(X)

def funcao2():
   global a, b, c, X
   c = 3
   d = 4
   X = c + d
   print(X)

funcao1()
funcao2()
