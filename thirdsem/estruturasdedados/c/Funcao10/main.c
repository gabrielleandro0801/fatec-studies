#include <stdio.h>
#include <stdlib.h>

int maior(int a, int b) {
    if (a > b) {
        return a;
    } else {
        return b;
    }
}

int main() {
    printf("Digite 2 numeros: ");
    int a, b;
    scanf("%d %d", &a, &b);
    int m = maior(a, b);
    printf("Maior = %d\n", m);

    return 0;
}
