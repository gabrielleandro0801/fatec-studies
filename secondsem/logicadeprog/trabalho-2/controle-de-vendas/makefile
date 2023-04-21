ControleDeVendas:  main.o compra.o cliente.o
	gcc -o ControleDeVendas main.o compra.o cliente.o

main.o: main.c compra.h cliente.h
	gcc -c main.c

compra.o: compra.c compra.h cliente.h
	gcc -c compra.c

cliente.o: cliente.c cliente.h
	gcc -c cliente.c
