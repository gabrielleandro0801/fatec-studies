#include <stdio.h>
#include <stdlib.h>

int converte(int h, int m, int s) {
    s += (h*3600) + (m*60);
}

int main() {
    printf("Digite a hora (hh:mm:ss): ");
    int h, m, s;
    scanf("%d %d %d", &h, &m, &s);
    s = converte(h, m, s);
    printf("Total de segundos: %d\n", s);

    return 0;
}
