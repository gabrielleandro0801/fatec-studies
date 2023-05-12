import serial
serB=serial.Serial("/dev/pts/7")
m = serB.readline().decode()
print(m)
