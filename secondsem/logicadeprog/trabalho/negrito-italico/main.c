// Autores: Gabriel Leandro Santos Sousa
//       Jo�o Vitor Santos Guedes
//       Matheus Carpeggiane Montenegro da Silva
//       ADS 2 Manh� - Prof. Ciro

#include <stdio.h>
#include <stdlib.h>
#include "my_html.h"

int main() {
    // string para receber o texto do usu�rio
    char texto[175];

    // recebendo o texto e chamando as fun��es
    while(fgets(texto, 51, stdin) != NULL) {
        negrito(texto);
        italico(texto);
        printf("%s", texto);
    }
    return 0;
}
