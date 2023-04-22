#include <stdio.h>
#include <stdlib.h>

int soma(int pri, int seg) {
    int i, caixa, maior, menor;
    if (pri > seg) {
        maior = pri;
        menor = seg;
    } else {
        maior = seg;
        menor = pri;
    }
    for (i = menor; i <= maior; i++) {
        caixa += i;
    }

    return caixa;
}

int main() {
    printf("Digite dois numeros: ");
    int a, b, total;
    scanf("%d %d", &a, &b);
    total = soma(a, b);
    printf("Total = %d\n", total);
    return 0;
}
