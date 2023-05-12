n = 100000000
r = 0
for i in range(1, int (n/2), 1):
   r = r + i
for i in range(int (n/2), n, 1):
   r = r + i

print(r)
