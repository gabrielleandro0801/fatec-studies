import threading

global r
r = 0

def calculo(inicio, fim):
   global r
   print(inicio, fim, 1)
   x = 0
   for i in range(inicio, fim, 1):
      x = x + i
      for j in range (1000):
         j = j
   r = r + x

n = 100000
t1=threading.Thread(target=calculo, args=(1, int(n/2), ))
t2=threading.Thread(target=calculo, args=(int(n/2), n, ))
t1.start()
t2.start()
t1.join()
t2.join()
print(r)
