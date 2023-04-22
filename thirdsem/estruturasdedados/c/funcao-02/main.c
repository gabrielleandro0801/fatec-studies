#include <stdio.h>
#include <stdlib.h>

void exibe_data(int dia, int mes, int ano) {
    printf("%d de ", dia);
    switch (mes) {
        case 1:
            printf("janeiro ");
            break;
        case 2:
            printf("fevereiro ");
            break;
        case 3:
            printf("marco ");
            break;
        case 4:
            printf("abril ");
            break;
        case 5:
            printf("maio ");
            break;
        case 6:
            printf("junho ");
            break;
        case 7:
            printf("julho ");
            break;
        case 8:
            printf("agosto ");
            break;
        case 9:
            printf("setembro ");
            break;
        case 10:
            printf("outubro ");
            break;
        case 11:
            printf("novembro ");
            break;
        case 12:
            printf("dezembro ");
            break;
    }
    printf("de %d\n", ano);
}

int main() {
    printf("Digite a data (dd/mm/aaaa): ");
    int dia, mes, ano;
    scanf("%d %d %d", &dia, &mes, &ano);
    exibe_data(dia, mes, ano);

    return 0;
}
