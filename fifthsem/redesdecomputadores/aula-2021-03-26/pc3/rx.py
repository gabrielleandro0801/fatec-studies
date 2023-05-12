import serial

ser3 = serial.Serial("/dev/pts/7")

msg = ser3.readline().decode()
print(msg)