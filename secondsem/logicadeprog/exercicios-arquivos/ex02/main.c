#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char * argv[]) {
    FILE * origem, * destino;
    char caractere;
    int chave = atoi(argv[3]);

    if (argc != 4) {
        printf("Erro! Informe <arquivo> <-c/-d> <chave>!\n");
        return 1;
    }

    if ((origem = fopen(argv[1], "r")) == NULL) {
        fprintf(stderr, "Erro ao abrir o arquivo %s!\n", argv[1]);
        return 2;
    }

    if ((destino = fopen("saida.txt", "w")) == NULL) {
        fprintf(stderr, "Erro ao abrir/criar o arquivo %s!\n", argv[1]);
        return 3;
    }

    if (strcmp(argv[2], "-c") == 0) {
        while((caractere = fgetc(origem)) != EOF) {
            caractere += chave;
            fputc(caractere, destino);
        }
    } else if (strcmp(argv[2], "-d") == 0) {
        while((caractere = fgetc(origem)) != EOF) {
            caractere -= chave;
            fputc(caractere, destino);
        }
    }

    fclose(origem);
    fclose(destino);
    printf("Criptografia/Descriptografia realizada com sucesso!\n");

    return 0;
}
