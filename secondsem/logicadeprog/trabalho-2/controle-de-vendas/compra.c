/*  Grupo:
    Gabriel Leandro Santos Sousa
    Jo�o Vitor Santos Guedes
    Matheus Carpeggiane Montenegro da Silva*/
#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include "compra.h"
#include "cliente.h"

void cadastrar_compra() {
    //Cria um ponteiro de arquivo
    FILE * pa;
    //Cria uma vari�vel do tipo struct
    compra c;

    //Cria um ponteiro de arquivo
    FILE * paCli;
    //Cria uma vari�vel do tipo struct
    cliente cli;

    //Cria uma vari�vel provis�ria para o c�digo do cliente
    int codCliente;

     //Tenta abrir o arquivo, se n�o ach�-lo emite uma mensagem de erro
    if ((pa = fopen(ARQ_COMPRA, "ab")) == NULL) {
        fprintf(stderr, "Erro ao abrir o arquivo %s!\n", ARQ_COMPRA);
        return;
    }

    //Tenta abrir o arquivo, se n�o ach�-lo emite uma mensagem de erro
    if ((paCli = fopen(ARQ_CLIENTE, "rb")) == NULL) {
        fprintf(stderr, "Erro ao abrir o arquivo %s!\n", ARQ_CLIENTE);
        return;
    }

    //Vai para o final do arquivo atrav�s do fseek
    fseek(pa, 0, SEEK_END);

    //V� quantas compras cadastradas existem e soma mais um para colocar no n�mero da compra
    c.numero_compra = ftell(pa)/sizeof(compra) + 1;

    //Cabe�alho
    printf("\n\nRealizar Compra\n");
    printf("Numero da Compra: %d\n", c.numero_compra);

    //Recebe o n�mero do cliente
    printf("Codigo do Cliente: ");
    scanf("%d", &codCliente);

    //Vai at� onde est� o cliente no arquivo atrav�s do fseek
    //A multiplica��o: o n� de clientes menos um vezes o tamanho de bytes, para ir at� o in�cio do cliente em quest�o
    fseek(paCli, (codCliente-1)*sizeof(cliente), SEEK_SET);
    //L� o cliente
    fread(&cli, sizeof(cliente), 1, paCli);

    //Verifica se o c�digo � valido ou se a posi��o � o final do arquivo
    if (codCliente <= 0 || feof(paCli)) {
        printf("Nao ha nenhum cliente com o codigo %d!\n\n", codCliente);
        return;
    }

    //Coloca o codigo informado dentro da struct
    c.codigo_cliente = codCliente;

    //Imprime o nome e pede a data
    printf("Nome do cliente: %s\n", cli.nome_cliente);
    printf("Data da Compra (digite XX XX XXXX): ");

    //Recebe a data da compra digitado pelo uu�rio
    scanf("%d %d %d", &c.dt_compra.dia, &c.dt_compra.mes, &c.dt_compra.ano);

    //Recebe o valor total da venda e valida se � maior ou n�o que 0
    do {
        printf("Valor da Compra: R$ ");
        scanf("%f", &c.valor);
    } while (c.valor <= 0);

    //Escreve no arquivo os dados da compra
    fwrite(&c, sizeof(compra), 1, pa);
    printf("Compra efetuada com sucesso!\n\n");

    //Fecha os arquivos
    fclose(pa);
    fclose(paCli);
}

void listar_compras_data() {
    //Cria um ponteiro de arquivo
    FILE * pa;
    //Cria uma vari�vel do tipo struct
    compra c;

    //Cria um ponteiro de arquivo
    FILE *paCli;
    //Cria uma vari�vel do tipo struct
    cliente cli;

    //Cria uma vari�vel do tipo struct
    data desejada;

    //Vari�vel para receber o valor total das compras naquela data
    float soma = 0;

    //Tenta abrir o arquivo, se n�o ach�-lo emite uma mensagem de erro
    if ((pa = fopen(ARQ_COMPRA, "rb")) == NULL) {
        fprintf(stderr, "Erro ao abrir o arquivo %s!\n", ARQ_COMPRA);
        return;
    }

    //Tenta abrir o arquivo, se n�o ach�-lo emite uma mensagem de erro
    if ((paCli = fopen(ARQ_CLIENTE, "rb")) == NULL) {
        fprintf(stderr, "Erro ao abrir o arquivo %s!\n", ARQ_CLIENTE);
        return;
    }

    //Imprime o cabe�alho
    printf("\n\nCompras por Data\n");
    printf("Informe a Data (XX XX XXXX): ");

    //Recebe os valores da data para filtro
    scanf("%d %d %d", &desejada.dia, &desejada.mes, &desejada.ano);

    //Vari�vel que conter� o n� de ocorr�ncias
    int caixa = 0;

    //Pega todos os registros do arquivo e verifica se as datas s�o iguais
    while (fread(&c, sizeof(compra), 1, pa) > 0) {
        if (datas_iguais(desejada, c.dt_compra) == 1) {
            //Se forem, caixa � incrementado
            caixa++;
        }
    }

    //Se o n� de ocorr�ncias (caixa) for igual a zero, ent�o n�o houve vendas
    if (caixa == 0) {
        fprintf(stderr, "Nao houve compras efetuadas no dia %02d/%02d/%4d!\n\n", desejada.dia, desejada.mes, desejada.ano);
        return;
    }

    //O indicador de posi��o volta ao in�cio do arquivo
    rewind(pa);

    //Imprime a data e os t�tulos
    printf("\nData: %02d/%02d/%4d\n", desejada.dia, desejada.mes, desejada.ano);
    printf("--------------------------------------------------------\n");
    printf("Num da Compra\tNome do Cliente\t\t\tValor\n");

    //Loop que pasa por todos os registros do arquivo
    while (fread(&c, sizeof(compra), 1, pa) > 0) {
        //Verifica novamente se a data digitada � igual a do arquivo
         if (datas_iguais(desejada, c.dt_compra) == 1) {
             //A variavel soma � acrescentada o valor da compra (Para chegar ao total)
            soma += c.valor;

            //Busca o nome do cliente e imprime com os dados da compra
            fseek(paCli, (c.codigo_cliente-1)*sizeof(cliente), SEEK_SET);
            fread(&cli, sizeof(cliente), 1, paCli);
            printf("%02d\t\t%-30.30s\tR$%.2f\n", c.numero_compra, cli.nome_cliente, c.valor);
         }
    }

    //Imprime o total
    printf("--------------------------------------------------------\n");
    printf("Total:\t\t\t\t\t\tR$%.2f\n\n", soma);

    //Fecha os arquivos
    fclose(pa);
    fclose(paCli);
    /* Ciro: n�o implementou a listagem em arquivo (Corretude: -0.5) (Interface: -1.0) */
}

bool datas_iguais(data DataDesejada, data DataEncontrada) {
    //Verifica se os dias s�o diferentes. Se sim, retorna 0
    if (DataDesejada.dia != DataEncontrada.dia) {
        return 0;
    }

    //Verifica se os meses s�o diferentes. Se sim, retorna 0
    if (DataDesejada.mes != DataEncontrada.mes) {
        return 0;
    }

    //Verifica se os anos s�o diferentes. Se sim, retorna 0
    if (DataDesejada.ano != DataEncontrada.ano) {
        return 0;
    }

    //Se todos iguais, retorna 1
    return 1;
}

void listar_compras_cliente() {
    //Cria um ponteiro de arquivo
    FILE * pa;
    //Cria uma vari�vel do tipo struct
    compra c;

    //Cria um ponteiro de arquivo
    FILE * paCli;
    //Cria uma vari�vel do tipo struct
    cliente cli;

    //Vari�vel para receber provisoriamente o c�digo do cliente
    int codCli;
    //Vari�vel para receber o valor total das compras do cliente
    float soma = 0;

    //Tenta abrir o arquivo, se n�o ach�-lo emite uma mensagem de erro
    if ((pa = fopen(ARQ_COMPRA, "rb")) == NULL) {
        fprintf(stderr, "Erro ao abrir o arquivo %s!\n", ARQ_COMPRA);
        return;
    }

    //Tenta abrir o arquivo, se n�o ach�-lo emite uma mensagem de erro
    if ((paCli = fopen(ARQ_CLIENTE, "rb")) == NULL) {
        fprintf(stderr, "Erro ao abrir o arquivo %s!\n", ARQ_CLIENTE);
        return;
    }

    //Pede o c�digo do cliente
    printf("\n\nInforme o Codigo do Cliente: ");
    scanf("%d", &codCli);

    //Vai at� onde est� o cliente no arquivo atrav�s do fseek
    //A multiplica��o: o n� de clientes menos um vezes o tamanho de bytes, para ir at� o in�cio do cliente em quest�o
    fseek(paCli, (codCli-1)*sizeof(cliente), SEEK_SET);
    //L� o cliente
    fread(&cli, sizeof(cliente), 1, paCli);

    //Se o c�digo informado for menor/igual a zero ou o indicador de posi��o for o final do arquivo, n�o h� nenhum cliente com aquele c�digo
    if (codCli <= 0 || feof(paCli)) {
        printf("Nao ha nenhum cliente com o codigo %d!\n\n", codCli);
        return;
    } else {
        //Caso contr�rio � impresso o nome do cliente
        printf("\nNome do Cliente: %s\n", cli.nome_cliente);
    }

    //Verifica se o cliente tem alguma compra. A vari�vel caixa conta o n� de compras do cliente
    int caixa = 0;
    while (fread(&c, sizeof(compra), 1, pa) > 0) {
        //Se o c�digo buscado for igual o c�digo cadastrado, caixa � incrementado e � adicionado o valor da compra na vari�vel soma
        if (c.codigo_cliente == codCli) {
            caixa++;
            soma += c.valor;
        }
    }

    //Se o n� de ocorr�ncias (caixa) for igual a zero, o cliente n�o possui compras efetuadas
    if (caixa == 0) {
        fprintf(stderr, "O cliente %d nao possui compras efetuadas!\n\n", codCli);
        return;
    }

    //Aqui o indicador de posi��o � deslocado para o in�cio do arquivo
    rewind(pa);

    //� impresso o cabe�alho
    printf("------------------------\n");
    printf("Data da compra\tValor\n");

    //Loop de leitura no arquivo
    while (fread(&c, sizeof(compra), 1, pa) > 0) {
        //Se os c�digos forem iguais, � impresso os dados da compra
        if (c.codigo_cliente == codCli) {
            printf("%02d/%02d/%4d\tR$%.2f\n", c.dt_compra.dia, c.dt_compra.mes, c.dt_compra.ano, c.valor);
        }
    }
    printf("------------------------\n");

    //Impress�o do valor total (vari�vel soma)
    printf("Valor total:\tR$%.2f\n\n", soma);

    //Fechamento dos arquivos apontado pelos ponteiros
    fclose(pa);
    fclose(paCli);
}
