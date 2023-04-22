#include <stdio.h>
#include <stdlib.h>

void imprime(int t) {
    int i, j;
    for (i = 1; i <= t; i++) {
        for (j = 1; j <= i; j++) {
            printf("!");
        }
        printf("\n");
    }
}

int main() {
    printf("Digite a quantidade de linhas: ");
    int d;
    scanf("%d", &d);
    imprime(d);

    return 0;
}
