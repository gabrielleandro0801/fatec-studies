#include <stdio.h>
#include <stdlib.h>

struct dados {
    char nome[20];
    int idade;
    char endereco[20];
};

int main() {
    struct dados ex;

    printf("Informe o nome: ");
    scanf("%19[^\n]", ex.nome);
    printf("Informe a idade: ");
    scanf("%d", &ex.idade);
    printf("Informe o endereco: ");
    scanf(" %19[^\n]", ex.endereco);

    printf("Nome: %s\n", ex.nome);
    printf("Idade: %d\n", ex.idade);
    printf("Endereco: %s\n", ex.endereco);

    return 0;
}
