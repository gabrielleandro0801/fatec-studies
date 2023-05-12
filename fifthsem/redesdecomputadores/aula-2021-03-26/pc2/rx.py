import serial

ser2 = serial.Serial("/dev/pts/2")

msg = ser2.readline().decode()
print(msg)