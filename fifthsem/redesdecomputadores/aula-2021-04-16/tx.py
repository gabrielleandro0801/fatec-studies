import serial
serA=serial.Serial("/dev/pts/6")
serA.write("Ola mundo\n".encode())
