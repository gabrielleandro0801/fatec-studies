#include <stdio.h>
#include <stdlib.h>

struct func {
    char nome[20];
    int idade;
    char sexo;
    long long int cpf;
    char dtNasc[10];
    int codSetor;
    char cargo[30];
    float sal;
};

int main() {
    printf("Preencha os dados:\n");
    struct func a;
    printf("Nome: ");
    scanf("%19[^\n]", a.nome);
    printf("Idade: ");
    scanf("%d", &a.idade);
    printf("Sexo: ");
    scanf(" %c", &a.sexo);
    printf("CPF: ");
    scanf("%lld", &a.cpf);
    printf("Data de nascimento: ");
    scanf(" %10[^\n]", a.dtNasc);
    printf("Codigo do setor: ");
    scanf("%d", &a.codSetor);
    printf("Cargo: ");
    scanf(" %29[^\n]", a.cargo);
    printf("Salario: ");
    scanf("%f", &a.sal);
    printf("---------------------------------\n");
    printf("Nome: %s\n", a.nome);
    printf("Idade: %d\n", a.idade);
    printf("Sexo: %c\n", a.sexo);
    printf("CPF: %lld\n", a.cpf);
    printf("Data de nascimento: %s\n", a.dtNasc);
    printf("Codigo do setor: %d\n", a.codSetor);
    printf("Cargo: %s\n", a.cargo);
    printf("Salario: %.2f\n", a.sal);

    return 0;
}
