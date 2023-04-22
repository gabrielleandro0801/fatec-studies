#include <stdio.h>
#include <stdlib.h>

int main() {
    float vet[10];
    int i;

    for (i = 0; i < 10; i++) {
        printf("%p\n", &vet[i]);
    }

    return 0;
}
