#include <stdio.h>
#include <stdlib.h>

int main() {
    int a, *b;
    float c, * d;
    char e, * f;

    printf("Informe um numero inteiro: ");
    scanf("%d", &a);
    printf("Informe um numero real: ");
    scanf("%f", &c);
    printf("Informe um caractere: ");
    scanf(" %c", &e);

    printf("\nNum Inteiro: %d\n", a);
    printf("Num Real: %.2f\n", c);
    printf("Caractere: %c\n", e);

    b = &a;
    d = &c;
    f = &e;

    printf("\nValores novos:\n");
    printf("Informe um numero inteiro: ");
    scanf("%d", b);
    printf("Informe um numero real: ");
    scanf("%f", d);
    printf("Informe um caractere: ");
    scanf(" %c", f);

    printf("\nNum Inteiro: %d\n", *b);
    printf("Num Real: %.2f\n", *d);
    printf("Caractere: %c\n", *f);

    return 0;
}
