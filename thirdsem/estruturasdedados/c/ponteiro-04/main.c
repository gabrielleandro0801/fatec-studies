#include <stdio.h>
#include <stdlib.h>

void inverte_valor(int * pri, int * seg) {
    int aux = *pri;
    *pri = *seg;
    *seg = aux;
}

void mostra_valor(int * pri, int * seg) {
    printf("A = %d\n", pri);
    printf("B = %d\n\n", seg);
}

int main() {
    printf("Informe dois valores: ");
    int * a, * b;
    a = (int *)malloc(sizeof(int));
    b = (int *)malloc(sizeof(int));

    scanf("%d", &a);
    scanf("%d", &b);

    mostra_valor(a, b);
    inverte_valor(&a, &b);
    mostra_valor(a, b);

    free(a);
    free(b);

    return 0;
}
