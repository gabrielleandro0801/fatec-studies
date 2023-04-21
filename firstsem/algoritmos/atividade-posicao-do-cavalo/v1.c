#include <stdio.h>

int main(void) {
  int linhaCavalo;
  char colunaCavalo[2];
  int colunaNum;

  int posicaoLinha[8];
  int posicaoColuna[8];
  char colunaImprimir[2];
  
  printf("Linhas: variam de 8 a 1\nColunas: variam de H a A\n");
  scanf("%d %s", &linhaCavalo, colunaCavalo);
  
  if(colunaCavalo[0] == 'A' || colunaCavalo[0] == 'a'){
    colunaNum = 1;
  } else if(colunaCavalo[0] == 'B' || colunaCavalo[0] == 'b'){
    colunaNum = 2;
  } else if(colunaCavalo[0] == 'C' || colunaCavalo[0] == 'c'){
    colunaNum = 3;
  } else if(colunaCavalo[0] == 'D' || colunaCavalo[0] == 'd'){
    colunaNum = 4;
  } else if(colunaCavalo[0] == 'E' || colunaCavalo[0] == 'e'){
    colunaNum = 5;
  } else if(colunaCavalo[0] == 'F' || colunaCavalo[0] == 'f'){
    colunaNum = 6;
  } else if(colunaCavalo[0] == 'G' || colunaCavalo[0] == 'g'){
    colunaNum = 7;
  } else if(colunaCavalo[0] == 'H' || colunaCavalo[0] == 'h'){
    colunaNum = 8;
  }

  //posicao 1
  posicaoLinha[0] = linhaCavalo + 2;
  posicaoColuna[0] = colunaNum + 1;

  //posicao 2
  posicaoLinha[1] = linhaCavalo + 1;
  posicaoColuna[1] = colunaNum + 2; 

  //posicao 3
  posicaoLinha[2] = linhaCavalo - 1;
  posicaoColuna[2] = colunaNum + 2;

  //posicao 4
  posicaoLinha[3] = linhaCavalo - 2;
  posicaoColuna[3] = colunaNum + 1;

  //posicao 5
  posicaoLinha[4] = linhaCavalo - 2;
  posicaoColuna[4] = colunaNum - 1;

  //posicao 6
  posicaoLinha[5] = linhaCavalo - 1;
  posicaoColuna[5] = colunaNum - 2;

  //posicao 7
  posicaoLinha[6] = linhaCavalo + 1;
  posicaoColuna[6] = colunaNum - 2;

  //posicao 8
  posicaoLinha[7] = linhaCavalo + 2;
  posicaoColuna[7] = colunaNum - 1;

  int contador = 0;
  for(contador = 0; contador < 8; contador++){
    if(linhaCavalo >0 && linhaCavalo <=8 && posicaoLinha[contador] > 0 && posicaoLinha[contador] <= 8 && posicaoColuna[contador] > 0 && posicaoColuna[contador] <= 8){
      if(posicaoColuna[contador] == 1){
        colunaImprimir[0] = 'A';
      } else if(posicaoColuna[contador] == 2){
        colunaImprimir[0] = 'B';
      } else if(posicaoColuna[contador] == 3){
        colunaImprimir[0] = 'C';
      } else if(posicaoColuna[contador] == 4){
        colunaImprimir[0] = 'D';
      } else if(posicaoColuna[contador] == 5){
        colunaImprimir[0] = 'E';
      } else if(posicaoColuna[contador] == 6){
        colunaImprimir[0] = 'F';
      } else if(posicaoColuna[contador] == 7){
        colunaImprimir[0] = 'G';
      } else if(posicaoColuna[contador] == 8){
        colunaImprimir[0] = 'H';
      }
      printf("Posicao valida: Linha = %d Coluna = %c (%d%c)\n", posicaoLinha[contador], colunaImprimir[0], posicaoLinha[contador], colunaImprimir[0]);
    }
  }
  
  return 0;
}
