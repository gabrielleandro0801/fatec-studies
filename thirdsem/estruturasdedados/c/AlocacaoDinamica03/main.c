#include <stdio.h>
#include <stdlib.h>

int main() {
    printf("Tamanho do vetor: ");
    int t;
    scanf("%d", &t);
    int * vet;
    vet = (int *)malloc(t * sizeof(int));

    int i;
    for (i = 0; i < t; i++) {
        scanf("%d", &vet[i]);
    }

    for (i = 0; i < t; i++) {
        if (vet[i] % 2 == 0) {
            printf("%d eh par\n", vet[i]);
        } else {
            printf("%d eh impar\n", vet[i]);
        }
    }

    return 0;
}
