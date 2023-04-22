#include <stdio.h>
#include <stdlib.h>

struct aluno {
    int matricula;
    char nome[20];
    int codDisc;
    float nota1, nota2;
};

void mostra_media(int t, struct aluno * copia) {
    int i;
    for (i = 0; i < t; i++) {
        printf("Aluno: %s\tMedia: %.2f\n", copia->nome, (copia->nota1 + (2 * copia->nota2))/3);
    }
}

int main() {
    // NAO TERMINADA
    // Laco para receber o tamanho da turma
    int tam;
    do {
        printf("Informe o tamanho da turma (max. 10 alunos): ");
        scanf("%d", &tam);
        if (tam > 10) {
            printf("Tamanho invalido! Tente novamente!\n");
        }
    } while (tam > 10);

    // Alocando os espa�os para o vetor de estruturas
    struct aluno * a;
    a = (struct aluno *)malloc(tam * sizeof(struct aluno));

    // Laco recebendo os dados dos alunos
    int i;
    printf("Dados dos alunos:\n");
    for (i = 0; i < tam; i++) {
        printf("\n\t%do aluno:", i+1);
        printf("\nMatricula: ");
        scanf("%d", &a->matricula);
        printf("Nome: ");
        scanf("%s", a->nome);
        printf("Cod Disciplina: ");
        scanf("%d", &a->codDisc);
        printf("Nota 1: ");
        scanf("%f", &a->nota1);
        printf("Nota 2: ");
        scanf("%f", &a->nota2);
    }

    mostra_media(tam, a);

    free(a);

    return 0;
}
