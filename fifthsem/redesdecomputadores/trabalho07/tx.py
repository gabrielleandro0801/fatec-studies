import serial

def transmite(porta):
	tx = serial.Serial("/dev/pts/" + porta)
	tx.write("Ola, receptor\n".encode())

	resposta = tx.readline().decode()
	print(f"{resposta}")

if __name__ == '__main__':
	porta = input('Numero da porta: ')
	transmite(porta)
