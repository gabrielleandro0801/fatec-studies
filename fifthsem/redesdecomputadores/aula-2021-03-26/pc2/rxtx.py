import serial

ser21 = serial.Serial("/dev/pts/2")

msg = ser21.readline().decode()
print(msg)

ser22 = serial.Serial("/dev/pts/6")
ser22.write(msg.encode())
