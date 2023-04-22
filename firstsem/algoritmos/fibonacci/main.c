#include <stdio.h>
#include <stdlib.h>

int fibonacci(int n) {
  if (n <= 1) {
    return n;
  }
  
  return fibonacci(n - 1) + fibonacci(n - 2);
}

int main(void) {
  int num;
  scanf("%d", &num);

  int i;
  for (i = 0; i < num; i++) {
    printf("%d ", fibonacci(i));
  }

  printf("%d\n", fibonacci(num));

  return 0;
}
