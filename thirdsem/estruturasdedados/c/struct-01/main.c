#include <stdio.h>
#include <stdlib.h>

struct horario {
    int h, m, s;
};

struct data {
    int d, m, a;
};

struct compromisso {
    char texto[50];
    struct data dt;
    struct horario hr;
};

int main() {
    struct compromisso cp;
    printf("Informe os dados do compromisso:\n");

    printf("Texto: ");
    scanf("%49[^\n]", cp.texto);
    printf("Dia: ");
    scanf("%d", &cp.dt.d);
    printf("Mes: ");
    scanf("%d", &cp.dt.m);
    printf("Ano: ");
    scanf("%d", &cp.dt.a);
    printf("Hora: ");
    scanf("%d", &cp.hr.h);
    printf("Minuto: ");
    scanf("%d", &cp.hr.m);
    printf("Segundo: ");
    scanf("%d", &cp.hr.s);

    printf("\nDados:\n");
    printf("Texto: %s\n", cp.texto);
    printf("Data: %02d/%02d/%4d\n", cp.dt.d, cp.dt.m, cp.dt.a);
    printf("Hora: %02d:%02d:%02d\n", cp.hr.h, cp.hr.m, cp.hr.s);

    return 0;
}
