#include <stdio.h>
#include <stdlib.h>

int main() {
    int * v, i, tamanho;
    printf("Digite o tamanho do vetor: ");
    scanf("%d", &tamanho);

    v = (int *)malloc(tamanho * sizeof(int));

    for (i = 0; i < tamanho; i++) {
        printf("%do valor: ", i+1);
        scanf("%d", &v[i]);
    }

    printf("\nVetor fornecido de %d posicoes:\n", tamanho);
    for (i = 0; i < tamanho; i++) {
        printf("%do valor: %d\n", i+1, v[i]);
    }

    free(v);

    return 0;
}
