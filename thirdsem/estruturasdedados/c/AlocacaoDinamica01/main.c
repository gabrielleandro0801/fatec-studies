#include <stdio.h>
#include <stdlib.h>

int main() {
    int * v;
    v = (int *)malloc(5 * sizeof(int));

    int i;
    for (i = 0; i < 5; i++) {
        printf("Digite o %do numero: ", i+1);
        scanf("%d", &v[i]);
    }

    for (i = 0; i < 5; i++) {
        printf("%do numero: %d\n", i+1, v[i]);
    }

    free(v);

    return 0;
}
