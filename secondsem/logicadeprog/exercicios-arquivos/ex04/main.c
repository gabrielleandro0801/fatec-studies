#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define FILENAME "todaschuvas.txt"

typedef struct {
    int dia;
    int mes;
    int ano;
} data;

typedef struct {
    data dt;
    int ind_pluviometrico;
} chuva;

void cadastra(void);
void gera(void);

int main() {
    int op;
    do {
        printf("<1> Cadastrar dia de chuva\n");
        printf("<2> Gerar arquivo com dias superiores a 60mm\n");
        printf("<0> Sair\n");
        scanf("%d", &op);
        switch(op) {
            case 1:
                cadastra();
                break;
            case 2:
                gera();
                break;
            case 0:
                break;
            default: printf("Opcao invalida!\n");
        }
    } while (op != 0);

    return 0;
}

void cadastra() {
    FILE * destino;
    chuva chu;

    if ((destino = fopen(FILENAME, "a")) == NULL) {
        fprintf(stderr, "\nERRO ao abrir o arquivo %s\n!", FILENAME);
        return;
    }

    printf("Informe as informacoes da chuva\n");
    printf("Data:\nDia: ");
    scanf("%d", &chu.dt.dia);
    printf("Mes: ");
    scanf("%d", &chu.dt.mes);
    printf("Ano: ");
    scanf("%d", &chu.dt.ano);
    printf("Indice pluviometrico: ");
    scanf("%d", &chu.ind_pluviometrico);
    fprintf(destino, "Data: %02d/%02d/%d - Indice: %d\n", chu.dt.dia, chu.dt.mes, chu.dt.ano, chu.ind_pluviometrico);
    fclose(destino);
}

void gera() {
    FILE * origem, * destino;
    chuva chu;
    char linha[121];
    if ((origem = fopen(FILENAME, "r")) == NULL) {
        fprintf(stderr, "\nERRO ao abrir o arquivo %s!\n", FILENAME);
        return;
    }
    if ((destino = fopen("chuvas.txt", "w")) == NULL) {
        fprintf(stderr, "ERRO ao abrir o arquivo chuvas.txt!\n");
        return;
    }
    while (fgets(linha, 121, origem) != NULL) {
        if (linha[25] >= '6') {
            fprintf(destino, "%s", linha);
        }
    }
    fclose(origem);
    fclose(destino);
}
