#include <stdio.h>
#include <stdlib.h>

int main() {
    //EXERCICIO 2.3 PDF
    int ano;

    scanf("%d", &ano);
    if (ano%4 == 0 || ano%100 == 0) {
        printf("Ano Bissexto");
    } else {
        printf("Ano nao Bissexto");
    }

    return 0;
}
