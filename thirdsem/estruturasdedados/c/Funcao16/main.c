#include <stdio.h>
#include <stdlib.h>

void desenhaLinha(int t) {
    int i;
    for (i = 0; i < t; i++) {
        printf("=");
    }
    printf("\n");
}

int main() {
    printf("Informe a quantidade de simbolos: ");
    int s;
    scanf("%d", &s);
    desenhaLinha(s);
    return 0;
}
