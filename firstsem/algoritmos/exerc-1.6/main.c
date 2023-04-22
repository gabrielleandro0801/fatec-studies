#include <stdio.h>
#include <stdlib.h>

int main() {
    // EXERCICIO 1.6 PDF
    double fa;
    double cel;

    scanf("%lf", &fa);
    cel = ((fa-32)*(5.0/9));
    printf("Celsius = %.2lf", cel);

    return 0;
}
