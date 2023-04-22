#include <stdio.h>
#include <stdlib.h>

int main()
{
    // EXERCICIO 1.4 PDF
    double distancia;
    double litros;
    double media;

    scanf("%lf %lf", &distancia, &litros);
    media = distancia/litros;
    printf("Km/litro = %.2lf", media);

    return 0;
}
