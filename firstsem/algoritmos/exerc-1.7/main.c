#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {
  // EXERCICIO 1.7 PDF
  double cat1;
  double cat2;
  double hipo;

  scanf("%lf %lf", &cat1, &cat2);
  hipo = sqrt(pow(cat1, 2)+pow(cat2, 2));
  printf("Hipotenusa = %.2lf", hipo);

  return 0;
}
