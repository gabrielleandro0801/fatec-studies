#include <stdio.h>
#include <stdlib.h>

int positivo(int num) {
    if (num < 0) {
        return -1;
    } else if (num == 0) {
        return 0;
    } else {
        return 1;
    }
}

int main() {
    printf("Digite um numero: ");
    int n, retorno;
    scanf("%d", &n);
    retorno = positivo(n);

    if (retorno < 0) {
        printf("Negativo\n");
    } else if (retorno == 0) {
        printf("Zero\n");
    } else {
        printf("Positivo\n");
    }

    return 0;
}
