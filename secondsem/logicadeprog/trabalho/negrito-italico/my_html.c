// Autores: Gabriel Leandro Santos Sousa
//       Jo�o Vitor Santos Guedes
//       Matheus Carpeggiane Montenegro da Silva
//       ADS 2 Manh� - Prof. Ciro


// bibliotecas e constantes
#include <string.h>
#include "my_html.h"

// fun��o negrito, que varre a string e pega a posi��o da primeira ocorr�ncia de *
// ao pegar, leva a string, a posi��o e a constante � fun��o replace
void negrito(char * frase) {
    int k = 0;
    while (frase[k] != '*') {
        k++;
    }
    replace(frase, k, ABRENEGRITO);
}

// fun��o it�lico, que varre a string e pega a posi��o da primeira ocorr�ncia de _
// ao pegar, leva a string, a posi��o e a constante � fun��o replace
void italico(char * frase) {
    int j = 0;
    while (frase[j] != '_') {
        j++;
    }
    replace(frase, j, ABREITALICO);
}

void replace(char * string, int posicao, const char * constante) {
    // cria��o de uma string de c�pia para fazer as altera��es
    char copia[175];

    // cria��o das vari�veis de aux�lio
    int i, j, k, l, posi = 0;

    // varrendo e limpando a string copia
    int a;
    for (a = 0; a < 175; a++) {
        copia[a] = ' ';
    }

    // decis�o: verifica se a constante que est� sendo recebida � a do Negrito ou do It�lico
    if (constante[1] == 'b') {
        // da posi��o zero at� a primeira ocorr�ncia, vai copiando a string pra c�pia
        for (i = 0; string[i] != '\0'; i++) {
            if (i != posicao) {
                copia[i] = string[i];
            } else {
                // ao chegar na posi��o, � inserida a constante (caracter por caracter)
                copia[i] = ABRENEGRITO[0];
                copia[i+1] = ABRENEGRITO[1];
                copia[i+2] = ABRENEGRITO[2];
                // ao inserir, o la�o � quebrado
                break;
            }
        }

        // da posi��o seguinte adiante, � procurado a pr�xima ocorr�ncia de asterisco
        for (j = i+1; string[j] != '\0'; j++) {
            if (string[j] != '*') {
                // enquanto isso, vai copiando o resto da string para a copia
                copia[j+2] = string[j];
            } else {
                // ao chegar na ocorr�ncia, � colocada a string de fechamento
                copia[j+2] = FECHANEGRITO[0];
                copia[j+3] = FECHANEGRITO[1];
                copia[j+4] = FECHANEGRITO[2];
                copia[j+5] = FECHANEGRITO[3];
                // e o la�o � quebrado
                break;
            }
        }

        // ap�s as duas inser��es, da posi��o seguinte � ocorr�ncia adiante, � terminado de copiar a string
        for (k = j+1; string[k] != '\0'; k++) {
            copia[k+5] = string[k];
        }
        // � inserido o '\0' ao final dela
        copia[k+5] = '\0';

        // varre a copia novamente para verificar se h� uma nova ocorr�ncia de *
        for (l = 0; copia[l] != '\0'; l++) {
            if (copia[l] == '*') {
                posi = l;
                // se encontrar, � salva a posi��o na vari�vel posi e o la�o � quebrado
                break;
            }
        }

        // se posi for diferente de zero (necessariamente quer dizer que h� uma nova ocorr�ncia)
        if (posi != 0) {
            // ent�o � chamada novamente a fun��o replace com a string copia, o valor de posi e a constante de abertura
            replace(copia, posi, ABRENEGRITO);
        } else {
            // e ent�o, � copiada a string descoberta para a string original
            strcpy(string, copia);
        }
    // aqui, caso a constante informada for a de it�lico
    } else {
        // da posi��o zero at� a primeira ocorr�ncia, vai copiando a string pra c�pia
        for (i = 0; string[i] != '\0'; i++) {
            if (i != posicao) {
                copia[i] = string[i];
            } else {
                // ao chegar na posi��o, � inserida a constante (caracter por caracter)
                copia[i] = ABREITALICO[0];
                copia[i+1] = ABREITALICO[1];
                copia[i+2] = ABREITALICO[2];
                // ao inserir, o la�o � quebrado
                break;
            }
        }

        // da posi��o seguinte adiante, � procurado a pr�xima ocorr�ncia de sublinha
        for (j = i+1; string[j] != '\0'; j++) {
            if (string[j] != '_') {
                // enquanto isso, vai copiando o resto da string para a copia
                copia[j+2] = string[j];
            } else {
                // ao chegar na ocorr�ncia, � colocada a string de fechamento
                copia[j+2] = FECHAITALICO[0];
                copia[j+3] = FECHAITALICO[1];
                copia[j+4] = FECHAITALICO[2];
                copia[j+5] = FECHAITALICO[3];
                // e o la�o � quebrado
                break;
            }
        }

        // ap�s as duas inser��es, da posi��o seguinte � ocorr�ncia adiante, � terminado de copiar a string
        for (k = j+1; string[k] != '\0'; k++) {
            copia[k+5] = string[k];
        }
        // � inserido o '\0' ao final dela
        copia[k+5] = '\0';

        // varre a copia novamente para verificar se h� uma nova ocorr�ncia de _
        for (l = 0; copia[l] != '\0'; l++) {
            if (copia[l] == '_') {
                posi = l;
                // se encontrar, � salva a posi��o na vari�vel posi e o la�o � quebrado
                break;
            }
        }

        // se posi for diferente de zero (necessariamente quer dizer que h� uma nova ocorr�ncia)
        if (posi != 0) {
            // ent�o � chamada novamente a fun��o replace com a string copia, o valor de posi e a constante de abertura
            replace(copia, posi, ABREITALICO);
        } else {
            // e ent�o, � copiada a string descoberta para a string original
            strcpy(string, copia);
        }
    }

    // ao final de tudo � copiada a string descoberta para a original novamente
    strcpy(string, copia);
}
