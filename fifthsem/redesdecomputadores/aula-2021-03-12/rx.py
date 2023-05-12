import serial

serB = serial.Serial("/dev/pts/2")
print(serB.readline().decode().replace('\n', ''))