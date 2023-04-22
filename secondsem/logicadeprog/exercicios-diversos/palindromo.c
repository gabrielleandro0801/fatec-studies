/*
Escreva um programa que receba uma string do teclado e informe se ela é palíndromo ou
não. Uma string é palíndromo quando pode ser lida tanto de trás para frente quanto de frente
para trás e possui exatamente a mesma sequência de caracteres. Por exemplo: “ASA”,
“SUBI NO ONIBUS”. Desconsidere os espaços.
*/

#include <stdio.h>
#include <string.h>

int main()
{
	char str[81], sem_espacos[81], inverso[81];
	int i, j;
	printf("Informe uma string: ");
	scanf("%80[^\n]", str);
	
	// retira os espaços
	for (i = 0, j = 0; str[i] != '\0'; i++) {
		if (str[i] != ' ') {
			sem_espacos[j++] = str[i];
		}
	}
	sem_espacos[j] = '\0';
	printf("String sem espacos: \"%s\"\n", sem_espacos);
	
	// inverte a string
	for (i = 0, j--; j >= 0; i++, j--) {
		inverso[i] = sem_espacos[j];
	}
	inverso[i] = '\0';
	
	if (strcasecmp(sem_espacos, inverso) == 0) {
		printf("\"%s\" E palindromo\n", str);
	}
	else {
		printf("\"%s\" NAO e palindromo\n", str);
	}

	return 0;
}
