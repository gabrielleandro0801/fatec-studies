/*  Grupo:
    Gabriel Leandro Santos Sousa
    João Vitor Santos Guedes
    Matheus Carpeggiane Montenegro da Silva*/
#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include <ctype.h>
#include "cliente.h"

void cadastrar_cliente(){
    //Cria um ponteiro de arquivo
    FILE * pa;

    //Cria uma variável do tipo struct
    cliente c;

    //Tenta abrir o arquivo, se não achá-lo emite uma mensagem de erro
    if((pa = fopen(ARQ_CLIENTE, "ab")) == NULL){
        fprintf(stderr, "Erro ao abrir o arquivo %s!\n", ARQ_CLIENTE);
        return;
    }

    //Vai para o final do arquivo através do fseek
    fseek(pa, 0, SEEK_END);

    //Vê quantos clientes cadastrados existem e soma mais um para colocar no id
    c.codigo_cliente = (ftell(pa)/sizeof(cliente)) + 1;

    //Recolhe os dados digitados e coloca na struct
    printf("\n\nNovo Cliente\n");
	printf("Codigo do cliente: %d\n", c.codigo_cliente);
	printf("Nome completo do cliente: ");
	scanf(" %50[^\n]", c.nome_cliente);
	printf("Telefone: ");
	scanf(" %14[^\n]", c.telefone);

	//Cadastra o cliente no arquivo
	fwrite(&c, sizeof(cliente), 1, pa);

	//Fecha o arquivo
	fclose(pa);

	//Exibe a mensagem de sucesso
	printf("\nCliente cadastrado com sucesso!\n\n");
}

void listar_clientes(){
    //Cria um ponteiro de arquivo
    FILE * pa;

    //Cria uma variável do tipo struct
    cliente c;

    //Tenta abrir o arquivo, se não achá-lo emite uma mensagem de erro
    if((pa = fopen(ARQ_CLIENTE, "rb")) == NULL){
        fprintf(stderr, "Erro ao abrir o arquivo %s!\n", ARQ_CLIENTE);
        return;
    }

    //Prints de cabeçalho
    printf("\nClientes Cadastrados\n");
    printf("------------------------------------------------------\n");
    printf("Cod\t\tNome\t\t\t      Telefone\n");

    //Vê a quantidade de registros no arquivo e faz o loop enquanto tiver registros que não foram printados
    while(fread(&c, sizeof(cliente), 1, pa) > 0){
         //Impressão dos dados
         printf("%02d\t\t%-30.30s%-15.15s\n", c.codigo_cliente, c.nome_cliente, c.telefone);
    }
    printf("------------------------------------------------------\n");

    //Fecha arquivo
    fclose(pa);
}

void consultar_cliente(){
    //Cria variaveis que serão utilizadas
    char nomeDesejado[51];
    char nomeDesejadoCopia[51];
    char nomeEncontrado[51];

    //Cria um ponteiro de arquivo
    FILE * pa;

    //Cria uma variável do tipo struct
    cliente c;

    //Tenta abrir o arquivo, se não achá-lo emite uma mensagem de erro
    if((pa = fopen(ARQ_CLIENTE, "rb")) == NULL){
        fprintf(stderr, "Erro ao abrir o arquivo %s!\n", ARQ_CLIENTE);
        return;
    }

    //Prints de cabeçalho
    printf("\n\nConsulta por Cliente\n");
    printf("Informe o primeiro nome do cliente: ");
    scanf(" %50[^\n]", nomeDesejado);

    //Aqui o nome informado pelo usuário é copiado pra variável nomeDesejadoCopia com todos os caracteres maiúsculos
    int i;
    for(i = 0; i < strlen(nomeDesejado); i++){
        nomeDesejadoCopia[i] = toupper(nomeDesejado[i]);
    }
    //Aqui ela recebe o fim da string
    nomeDesejadoCopia[i] = '\0';

    //A variável caixa conterá o nº de ocorrências do nome procurado
    int caixa = 0;
    while(fread(&c, sizeof(cliente), 1, pa) > 0){
        int i;
        /* Ciro: poderia ter usado a função strncasecmp() (Legibilidade: -0.25) */
        //Nesse laço, o membro nome_cliente da struct é varrido até a primeira ocorrência de espaço
        /* Ciro: se não houver espaço em branco no nome do cliente cadastrado,
         * ocorre um erro (Corretude: -0.25) (Interface: -0.5) */
        for(i = 0; c.nome_cliente[i]!= ' '; i++){
            //A variável nomeEncontrado vai recebendo os caracteres do nome_cliente transformados para maiúsculos
            nomeEncontrado[i] = toupper(c.nome_cliente[i]);
        }
        //Aqui ela recebe o fim da string
        nomeEncontrado[i] = '\0';

        //Se as strings forem iguais, caixa é incrementado
        if(strcmp(nomeDesejadoCopia, nomeEncontrado) == 0){
            caixa++;
        }
    }

    //Se o nº de ocorrências (caixa) for maior que zero, é porque o nome buscado está cadastrado
    if(caixa > 0){
        //Aqui o indicador de posição volta ao início do arquivo
        rewind(pa);

        //Vê a quantidade de registros no arquivo e faz o loop enquanto houver registros que não foram verificados
        while(fread(&c, sizeof(cliente), 1, pa) > 0){
            int i;
            //De novo pega o membro nome_cliente e lhe copia para a nomeEncontrado com os caracteres maiúsculos
            for(i = 0; c.nome_cliente[i]!= ' '; i++){
                nomeEncontrado[i] = toupper(c.nome_cliente[i]);
            }
            //Recebe o fim de string
            nomeEncontrado[i] = '\0';

            //Novamente, se as strings comparadas forem iguais, o cliente é impresso
            if(strcmp(nomeDesejadoCopia, nomeEncontrado) == 0){
                printf("----------------------------------------\n");
                printf("Codigo do Cliente: %d\n", c.codigo_cliente);
                printf("Nome do Cliente: %s\n", c.nome_cliente);
                printf("Telefone do Cliente: %s\n", c.telefone);
            }
        }
        printf("\n");
    }else{
        //Caso não haja ninguém com aquele nome. é exibida uma mensagem
        fprintf(stderr, "Nao ha nenhum cliente com esse nome!\n\n");
    }

    //Fecha o arquivo
    fclose(pa);
}
