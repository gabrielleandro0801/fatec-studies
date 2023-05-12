import serial

def recebe(porta):
	rx = serial.Serial("/dev/pts/" + porta)

	resposta = rx.readline().decode()
	print(f"{resposta}")
	
	rx.write("Ola, transmissor\n".encode())

	

if __name__ == '__main__':
	porta = input('Numero da porta: ')
	recebe(porta)
