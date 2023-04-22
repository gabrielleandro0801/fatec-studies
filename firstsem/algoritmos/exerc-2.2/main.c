#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

int main() {
    // EXERCICIO 2.2 PDF
    double A;
    double B;

    scanf("%lf %lf", &A, &B);
    if (A==B) {
        printf("S�o iguais!");
    } else if (A>B) {
        printf("%lf e maior", A);
    } else{
        printf("%.2lf e maior", B);
    }

    return 0;
}
