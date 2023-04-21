#include <stdio.h>
#include <stdlib.h>
#include <locale.h> //tag para mostrar acentos no printf

char bin[8];
int binario(int x ) {
  int j;

  for (j= 7; j >= 0; j--) {
    if (x % 2 == 0) {
      bin[j] = '0';
      x = x / 2;
    }
    else {
      bin[j] = '1';
      x = x / 2;
    }
  }
}

int main(){
    printf("RA: 1430481911037\n");
    printf("RA: 1430481911007\n");
    printf("RA: 1430481911034\n");

    FILE *pa;
    int paginas = 800;
    float preco = 79.95;
    int i;

    if ((pa = fopen("jj.html", "w"))) {
        fprintf(pa,"<html>\n");
        fprintf(pa,"<head>\n");
        fprintf(pa,"<title>Minha primeira vez</title>\n");
        fprintf(pa,"<body BGCOLOR=lawngreen>");
        fprintf(pa,"<h1>RA: 1430481911037</h1>");
        fprintf(pa,"<h1>RA: 1430481911007</h1>");
        fprintf(pa,"<h1>RA: 1430481911034</h1><br> ");
        fprintf(pa,"<h1>TABELA</h1>\n");
        fprintf(pa,"<table border=\"1\">");
        fprintf(pa, "<td>DEC</td> <td>BIN</td> <td>OCT</td> <td>HEX</td>");

        for(i = 0; i < 16; i++) {
            binario(i);
            fprintf(pa,"<tr> <td>%d </td>  <td> %s </td> <td> %o </td>  <td> %x </td> </tr>", i , bin , i , i);
        }

        fprintf(pa,"</table>\n");
        fprintf(pa,"</body>\n");
        fprintf(pa,"</html>\n");

        fclose(pa);
    } else {
        printf("Erro ao abrir fprintf(arq)");
    }

    return 0;
}
