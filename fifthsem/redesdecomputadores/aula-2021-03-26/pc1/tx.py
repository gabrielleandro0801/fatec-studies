import serial

ser1 = serial.Serial("/dev/pts/1")
msg = "Ola mundo\n"
ser1.write(msg.encode())