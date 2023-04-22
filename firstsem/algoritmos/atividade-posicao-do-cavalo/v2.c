#include <stdio.h>

int main(void) {
  int linha = 0;
  char coluna;

  printf("Linhas (8 - 1) e Colunas (A - H)\n");
  scanf("%d %c", &linha, &coluna);

  if (linha == 8 && (coluna == 'A' || coluna == 'a')) {
    printf("Posicoes possiveis: 7C e 6B");
  } else if (linha == 8 && (coluna == 'B' || coluna == 'b')) {
    printf("Posicoes possiveis: 6A, 6C e 7D");
  } else if (linha == 8 && (coluna == 'C' || coluna == 'c')) {
    printf("Posicoes possiveis: 7A, 6B, 6D e 7E");
  } else if (linha == 8 && (coluna == 'D' || coluna == 'd')) {
    printf("Posicoes possiveis: 7B, 6C, 6E e 7F");
  } else if (linha == 8 && (coluna == 'E' || coluna == 'e')) {
    printf("Posicoes possiveis: 7C, 6D, 6F e 7G");
  } else if (linha == 8 && (coluna == 'F' || coluna == 'f')) {
    printf("Posicoes possiveis: 7D, 6E, 6G e 7H");
  } else if (linha == 8 && (coluna == 'G' || coluna == 'g')) {
    printf("Posicoes possiveis: 7E, 6F e 6H");
  } else if (linha == 8 && (coluna == 'H' || coluna == 'h')) {
    printf("Posicoes possiveis: 7F e 6G");
  }
  else if (linha == 7 && (coluna == 'A' || coluna == 'a')) {
    printf("Posicoes possiveis: 8C, 6C e 5B");
  } else if (linha == 7 && (coluna == 'B' || coluna == 'b')) {
    printf("Posicoes possiveis: 5A, 8D, 6D e 5C");
  } else if (linha == 7 && (coluna == 'C' || coluna == 'c')) {
    printf("Posicoes possiveis: 8A, 6A, 5B, 8E, 6E e 5D");
  } else if (linha == 7 && (coluna == 'D' || coluna == 'd')) {
    printf("Posicoes possiveis: 8B, 6B, 5C, 5E, 6F e 8F");
  } else if (linha == 7 && (coluna == 'E' || coluna == 'e')) {
    printf("Posicoes possiveis: 8C, 6C, 5D, 5F, 6G e 8G");
  } else if (linha == 7 && (coluna == 'F' || coluna == 'f')) {
    printf("Posicoes possiveis: 8D, 6D, 5E, 5G, 6H e 8H");
  } else if (linha == 7 && (coluna == 'G' || coluna == 'g')) {
    printf("Posicoes possiveis: 8E, 6E, 5F e 5H");
  } else if (linha == 7 && (coluna == 'H' || coluna == 'h')) {
    printf("Posicoes possiveis: 8F, 6F e 5G");
  }
  else if (linha == 6 && (coluna == 'A' || coluna == 'a')) {
    printf("Posicoes possiveis: 8B, 7C, 5C e 4B");
  } else if (linha == 6 && (coluna == 'B' || coluna == 'b')) {
    printf("Posicoes possiveis: 8A, 8C, 7D, 5D, 4C e 4A");
  } else if (linha == 6 && (coluna == 'C' || coluna == 'c')) {
    printf("Posicoes possiveis: 7A, 8B, 8D, 7E, 5E, 4D, 4B e 5A");
  } else if (linha == 6 && (coluna == 'D' || coluna == 'd')) {
    printf("Posicoes possiveis: 8C, 8E, 7F, 5F, 4E, 4C, 5B e 7B");
  } else if (linha == 6 && (coluna == 'E' || coluna == 'e')) {
    printf("Posicoes possiveis: 8D, 8F, 7G, 5G, 4F, 4D, 5C e 7C");
  } else if (linha == 6 && (coluna == 'F' || coluna == 'f')) {
    printf("Posicoes possiveis: 8E, 8G, 7H, 5H, 4G, 4E, 5D e 7D");
  } else if (linha == 6 && (coluna == 'G' || coluna == 'g')) {
    printf("Posicoes possiveis: 8F, 8H, 4H, 4F, 5E e 7E");
  } else if (linha == 6 && (coluna == 'H' || coluna == 'h')) {
    printf("Posicoes possiveis: 8G, 4G, 5F e 7F");
  }
  else if (linha == 5 && (coluna == 'A' || coluna == 'a')) {
    printf("Posicoes possiveis: 7B, 6C, 4C e 3B");
  } else if (linha == 5 && (coluna == 'B' || coluna == 'b')) {
    printf("Posicoes possiveis: 7A, 7C, 6D, 4D, 3C e 3A");
  } else if (linha == 5 && (coluna == 'C' || coluna == 'c')) {
    printf("Posicoes possiveis: 7B, 7D, 6E, 4E, 3D, 3B, 4A e 6A");
  } else if (linha == 5 && (coluna == 'D' || coluna == 'd')) {
    printf("Posicoes possiveis: 7C, 7E, 6F, 4F, 3E, 3C, 4B e 6B");
  } else if (linha == 5 && (coluna == 'E' || coluna == 'e')) {
    printf("Posicoes possiveis: 7D, 7F, 6G, 4G, 3F, 3D, 4C e 6C");
  } else if (linha == 5 && (coluna == 'F' || coluna == 'f')) {
    printf("Posicoes possiveis: 7E, 7G, 6H, 4H, 3G, 3E, 4D e 6D");
  } else if (linha == 5 && (coluna == 'G' || coluna == 'g')) {
    printf("Posicoes possiveis: 7F, 7H, 3H, 3F, 4E e 6E");
  } else if (linha == 5 && (coluna == 'H' || coluna == 'h')) {
    printf("Posicoes possiveis: 7G, 3G, 4F e 6F");
  }
  else if (linha == 4 && (coluna == 'A' || coluna == 'a')) {
    printf("Posicoes possiveis: 6B, 5C, 3C e 2B");
  } else if (linha == 4 && (coluna == 'B' || coluna == 'b')) {
    printf("Posicoes possiveis: 6A, 6C, 5D, 3D, 2C e 2A");
  } else if (linha == 4 && (coluna == 'C' || coluna == 'c')) {
    printf("Posicoes possiveis: 6B, 6D, 5E, 3E, 2D, 2B, 3A e 5A");
  } else if (linha == 4 && (coluna == 'D' || coluna == 'd')) {
    printf("Posicoes possiveis: 6C, 6E, 5F, 3F, 2E, 2C, 3B e 5B");
  } else if (linha == 4 && (coluna == 'E' || coluna == 'e')) {
    printf("Posicoes possiveis: 6D, 6F, 5G, 3G, 2F, 2D, 3C e 5C");
  } else if (linha == 4 && (coluna == 'F' || coluna == 'f')) {
    printf("Posicoes possiveis: 6E, 6G, 5H, 3H, 2G, 2E, 3D e 5D");
  } else if (linha == 4 && (coluna == 'G' || coluna == 'g')) {
    printf("Posicoes possiveis: 6F, 6H, 2H, 2F, 3E e 5E");
  } else if (linha == 4 && (coluna == 'H' || coluna == 'h')) {
    printf("Posicoes possiveis: 6G, 2G, 3F e 5F");
  }
  else if (linha == 3 && (coluna == 'A' || coluna == 'a')) {
    printf("Posicoes possiveis: 5B, 4C, 2C e 1B");
  } else if (linha == 3 && (coluna == 'B' || coluna == 'b')) {
    printf("Posicoes possiveis: 5A, 5C, 4D, 2D, 1C e 1A");
  } else if (linha == 3 && (coluna == 'C' || coluna == 'c')) {
    printf("Posicoes possiveis: 5B, 5D, 4E, 2E, 1D, 1B, 2A e 4A");
  } else if (linha == 3 && (coluna == 'D' || coluna == 'd')) {
    printf("Posicoes possiveis: 5C, 5E, 4F, 2F, 1E, 1C, 2B e 4B");
  } else if (linha == 3 && (coluna == 'E' || coluna == 'e')) {
    printf("Posicoes possiveis: 5D, 5F, 4G, 2G, 1F, 1D, 2C e 4C");
  } else if (linha == 3 && (coluna == 'F' || coluna == 'f')) {
    printf("Posicoes possiveis: 5E, 5G, 4H, 2H, 1G, 1E, 2D e 4D");
  } else if (linha == 3 && (coluna == 'G' || coluna == 'g')) {
    printf("Posicoes possiveis: 5F, 5H, 1H, 2E e 4E");
  } else if (linha == 3 && (coluna == 'H' || coluna == 'h')) {
    printf("Posicoes possiveis: 5G, 1G, 2F e 4F");
  }
  else if (linha == 2 && (coluna == 'A' || coluna == 'a')) {
    printf("Posicoes possiveis: 4B, 3C e 1C");
  } else if (linha == 2 && (coluna == 'B' || coluna == 'b')) {
    printf("Posicoes possiveis: 4A, 4C, 3D e 1D");
  } else if (linha == 2 && (coluna == 'C' || coluna == 'c')) {
    printf("Posicoes possiveis: 4B, 4D, 3E, 1E, 1A e 3A");
  } else if (linha == 2 && (coluna == 'D' || coluna == 'd')) {
    printf("Posicoes possiveis: 4C, 4E, 3F, 1F, 1B e 3B");
  } else if (linha == 2 && (coluna == 'E' || coluna == 'e')) {
    printf("Posicoes possiveis: 4D, 4F, 3G, 1G, 1C e 3C");
  } else if (linha == 2 && (coluna == 'F' || coluna == 'f')) {
    printf("Posicoes possiveis: 4E, 4G, 3H, 1H, 1D e 3D");
  } else if (linha == 2 && (coluna == 'G' || coluna == 'g')) {
    printf("Posicoes possiveis: 4F, 4H, 1E e 3E");
  } else if (linha == 2 && (coluna == 'H' || coluna == 'h')) {
    printf("Posicoes possiveis: 4G, 1F e 3F");
  }
  else if (linha == 1 && (coluna == 'A' || coluna == 'a')) {
    printf("Posicoes possiveis: 3B e 2C");
  } else if (linha == 1 && (coluna == 'B' || coluna == 'b')) {
    printf("Posicoes possiveis: 3A, 3C e 2D");
  } else if (linha == 1 && (coluna == 'C' || coluna == 'c')) {
    printf("Posicoes possiveis: 3B, 3D, 2E e 2A");
  } else if (linha == 1 && (coluna == 'D' || coluna == 'd')) {
    printf("Posicoes possiveis: 3C, 3E, 2F e 2B");
  } else if (linha == 1 && (coluna == 'E' || coluna == 'e')) {
    printf("Posicoes possiveis: 3D, 3F, 2G e 2C");
  } else if (linha == 1 && (coluna == 'F' || coluna == 'f')) {
    printf("Posicoes possiveis: 3E, 3F, 2H e 2D");
  } else if (linha == 1 && (coluna == 'G' || coluna == 'g')) {
    printf("Posicoes possiveis: 3F, 3H e 2E");
  } else if (linha == 1 && (coluna == 'H' || coluna == 'h')) {
    printf("Posicoes possiveis: 3G e 2F");
  } else{
    printf("Posicao invalida!\nLinhas: 8 - 1 e Colunas A - H");
  }

  return 0;
}
