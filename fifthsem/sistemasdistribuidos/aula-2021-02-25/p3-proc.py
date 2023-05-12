import multiprocessing

global r
r = multiprocessing.Value('L', 0)
r.value = 0

def calculo(inicio, fim):
   global r
   print(inicio, fim, 1)
   x = 0 
   for i in range(inicio, fim, 1):
      x = x + i
      for j in range (1000):
         j = j
   r.value = r.value + x

if __name__ == '__main__':
  n = 100000
  p1=multiprocessing.Process(target=calculo, args=(1, int(n/2), ))
  p2=multiprocessing.Process(target=calculo, args=(int(n/2), n, ))
  p1.start()
  p2.start()
  p1.join()
  p2.join()
  print(r.value)
