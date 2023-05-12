import threading

global x
x = 0
global a 
a = 0
global b
b = 0
global op
op = ''

def funcao():
    global x, a, b, op
    if op == '+':
        x = a + b

a = 1
b = 2
op = '+'
t1 = threading.Thread(target = funcao, args = ())
t1.start()
t1.join()
print(x)
