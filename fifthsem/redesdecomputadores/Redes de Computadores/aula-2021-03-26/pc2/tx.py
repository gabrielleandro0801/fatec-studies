import serial

ser2 = serial.Serial("/dev/pts/6")
msg = "Ola mundo\n"
ser2.write(msg.encode())