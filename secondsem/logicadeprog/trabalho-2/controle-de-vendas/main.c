/*  Grupo:
    Gabriel Leandro Santos Sousa
    Jo�o Vitor Santos Guedes
    Matheus Carpeggiane Montenegro da Silva*/
#include <stdio.h>
#include <stdlib.h>
#include "cliente.h"
#include "compra.h"

int main() {
    // Vari�vel que receber� a op��o do usu�rio
    int operacao;
    do {
        // Impress�o das op��es do menu
        printf("\tMenu\n");
        printf("<1> Cadastrar Cliente\n");
        printf("<2> Listar Clientes Cadastrados\n");
        printf("<3> Consulta por Cliente\n");
        printf("<4> Cadastro de Compra\n");
        printf("<5> Listar Compras por Data\n");
        printf("<6> Listar Compras por Cliente\n");
        printf("<0> Sair do Programa\n");
        printf("Sua opcao: ");
        // Recebe a op��o que o usu�rio digitar
        scanf("%d", &operacao);

        // Estrutura condicional que chama um m�todo de acordo com a op��o digitada
        switch (operacao) {
            case 1: cadastrar_cliente();
                break;
            case 2: listar_clientes();
                break;
            case 3: consultar_cliente();
                break;
            case 4: cadastrar_compra();
                break;
            case 5: listar_compras_data();
                break;
            case 6: listar_compras_cliente();
                break;
            case 0: break;
            default: printf("Erro: Opcao Invalida!\n");
        }
    // Loop que enquanto ele n�o escolher a op��o 0 vai continuar em execu��o
    } while (operacao != 0);

    return 0;
}

/*---------------------------
           AVALIA��O
  ---------------------------
         APRESENTA��O
  ---------------------------
  - Gabriel Leandro....: 10.0
  - Jo�o Vitor.........:  9.0
  - Matheus Carpeggiane:  8.5
  ---------------------------
         C�DIGO FONTE
  ---------------------------
  - Corretude...:  9.25
  - Interface...:  8.50
  - Legibilidade:  9.75
  - Nota........:  9.15
  ---------------------------
       NOTA DO TRABALHO
  ---------------------------
  - Gabriel Leandro....: 9.55
  - Jo�o Vitor.........: 9.10
  - Matheus Carpeggiane: 8.80
  ---------------------------*/
