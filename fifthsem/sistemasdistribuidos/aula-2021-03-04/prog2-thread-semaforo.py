import threading

# semaforo
# esse 1 diz quantas regioes criticas podem ocorrer simultaneamente
s = threading.Semaphore(1)

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
   while(True):
      a = 1
      b = 2
      s.acquire()
      for i in range(10000):
         X = a + b
         if (X != 3):
            print("erro1")
#      print(X)
      s.release()

def funcao2():
   global a, b, c, X
   while(True):
      c = 3
      d = 4
      s.acquire()
      for i in range(10000):
         X = c + d
         if (X != 7):
            print("erro2")
#      print(X)
      s.release()
t1 = threading.Thread(target=funcao1)
t2 = threading.Thread(target=funcao2)
t1.start()
t2.start()
t1.join()
t2.join()
