import serial

serA = serial.Serial("/dev/pts/1")
serA.write("Ola mundo\n".encode())