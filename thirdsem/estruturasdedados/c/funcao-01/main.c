#include <stdio.h>
#include <stdlib.h>

int dobra(int numero) {
    numero *= 2;
    return numero;
}

int main() {
    int num;
    printf("Digite um numero: ");
    scanf("%d", &num);
    num = dobra(num);
    printf("Numero dobrado: %d\n", num);

    return 0;
}
