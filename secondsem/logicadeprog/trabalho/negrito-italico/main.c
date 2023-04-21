//Autores: Gabriel Leandro Santos Sousa
//         João Vitor Santos Guedes
//         Matheus Carpeggiane Montenegro da Silva
//         ADS 2 Manhã - Prof. Ciro

#include <stdio.h>
#include <stdlib.h>
#include "my_html.h"

int main(){
    //string para receber o texto do usuário
    char texto[175];

    //recebendo o texto e chamando as funções
    while(fgets(texto, 51, stdin) != NULL){
        negrito(texto);
        italico(texto);
        printf("%s", texto);
    }
    return 0;
}
