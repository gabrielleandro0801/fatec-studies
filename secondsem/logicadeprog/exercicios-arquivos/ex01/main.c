#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#define ORIGEM "origem.txt"

int main(int argc, char * argv[]){
    FILE * origem, * destino;
    char caractere;

    if (argc != 3) {
        fprintf(stderr, "Erro! Informe <origem> <destino>!");
        return 1;
    }

    if ((origem = fopen(argv[1], "r")) == NULL) {
        fprintf(stderr, "Erro ao abrir o arquivo origem.txt!");
        return 2;
    }

    if ((destino = fopen(argv[2], "w")) == NULL) {
        fprintf(stderr, "Erro ao abrir/criar o arquivo destino.txt!");
        fclose(origem);
        return 3;
    }

    while ((caractere = fgetc(origem)) != EOF) {
        fputc(toupper(caractere), destino);
    }

    fclose(origem);
    fclose(destino);
    printf("Copia realizada com sucesso!");

    return 0;
}
