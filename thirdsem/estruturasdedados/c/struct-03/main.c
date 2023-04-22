#include <stdio.h>
#include <stdlib.h>

struct aluno {
    char nome[20];
    int numMat;
    char curso[20];
};

void insere_aluno(struct aluno * a, int posi) {
    printf("\nNome: ");
    scanf(" %19[^\n]", a[posi].nome);
    printf("Num de matricula: ");
    scanf("%d", &a[posi].numMat);
    printf("Curso: ");
    scanf(" %19[^\n]", a[posi].curso);
}

void mostra_aluno(struct aluno * al, int posi) {
    printf("\n\nNome: %s", al[posi].nome);
    printf("\nNumero de matricula: %d", al[posi].numMat);
    printf("\nCurso: %s", al[posi].curso);
}

int main() {
    struct aluno * al;
    printf("Informe os dados dos alunos:\n");

    al = (struct aluno *)malloc(5 * sizeof(struct aluno));

    int i;
    for (i = 0; i < 5; i++) {
        insere_aluno(al, i);
    }

    printf("----------------------------------------------------\n");
    for (i = 0; i < 5; i++) {
        mostra_aluno(al, i);
    }
    printf("\n");

    free(al);

    return 0;
}
