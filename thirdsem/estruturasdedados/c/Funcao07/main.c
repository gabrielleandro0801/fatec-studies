#include <stdio.h>
#include <stdlib.h>

float grau(int cel) {
    float fah = cel * (9.0/5.0) + 32.0;
    return fah;
}

int main() {
    printf("Digite a temperatura em celsius: ");
    float cels, fah;
    scanf("%f", &cels);
    fah = grau(cels);
    printf("Em fahrenheit: %.2f\n", fah);

    return 0;
}
