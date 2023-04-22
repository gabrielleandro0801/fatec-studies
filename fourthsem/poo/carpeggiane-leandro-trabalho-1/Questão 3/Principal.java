import java.util.ArrayList;
import java.util.Scanner;

public class Principal{
    
    public static void imprimeQuadra(){
        System.out.println(">-------------------------------------------------------<");
        System.out.println("|                           |                           |");
        System.out.println("|                           |                           |       **      **   ******     * * * *   **       * *       *     * * *");
        System.out.println("|________                   |                   ________|       *  *   * *  *      *   *          *  *     * *       *   *");
        System.out.println("|        |                  |                  |        |       *   * *  *  *      *  *           *   *    * *       *     * * *");
        System.out.println("|___     |                . | .                |     ___|       *    *   *  ********  *    *****  *    *   * *       *           *");
        System.out.println("|   |    |              .   |   .              |    |   |       *        *  *      *   *        * *     *  * *       *   *      *");
        System.out.println("|   |    |*            .    o    .            *|    |   |       *        *  *      *     *******  *      **   * * * *     * * *");
        System.out.println("|___|    |              .   |   .              |    |___|");
        System.out.println("|        |                . | .                |        |       * * * * *  *       *  * * * * *     * * *     ******   *");
        System.out.println("|________|                  |                  |________|       *          *       *      *       *          *      *  *");
        System.out.println("|                           |                           |       *          *       *      *         * * *    *      *  *");
        System.out.println("|                           |                           |       * * * *    *       *      *               *  ********  *");
        System.out.println("|                           |                           |       *          *       *      *       *      *   *      *  *");
        System.out.println(">-------------------------------------------------------<       *           * * * *       *        * * *     *      *  * * * * *");
    }
    
    public static int leNumeroInteiro() {
		String base;
		int convertido;
		Scanner scanner = new Scanner(System.in);

        do {
            base = scanner.next();
            try {
                convertido = Integer.parseInt(base);
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas numeros inteiros. Tente Novamente");
                convertido = -1;
            }
        } while(convertido < 0);

        return convertido;
    }
    
    public static double leNumeroDouble() {
		String base;
		double convertido;
		Scanner scanner = new Scanner(System.in);
        do {
            base = scanner.next();
            try {
                convertido = Double.parseDouble(base);
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas numeros flutuantes. Tente Novamente");
                convertido = -1;
            }
        } while (convertido < 0);
        return convertido;
	}
    public static void main(String[] args){
        imprimeQuadra();

        Scanner scanner = new Scanner(System.in);
        String nome, dataContratacao, posicao;
        int contador, experiencia, numero, opcao, resultado;
        double salario, folhaSalarial = 16000;
        boolean pgtoRealizado, status = true;

        Tecnico tecnico;
        Dirigente dirigente;
        Jogador jogador;
        ArrayList<Jogador> alJogador = new ArrayList<Jogador>();
        
        System.out.println("Ola, seja bem vindo!");
        System.out.println("Voce acaba de se tornar o dirigente do Magnus Futsal!");
        System.out.println("Seu salario sera fixo de R$9.000!");

        System.out.println("Digite seu nome: ");
        nome = scanner.next(); 
        
        System.out.println("Digite sua data de contratacao: ");
        dataContratacao = scanner.next(); 
        dirigente = new Dirigente(nome, 9000, dataContratacao);

        System.out.println("\n");
        System.out.println("Ola, " + nome);
        System.out.println("Agora, contrate seu treinador. Ele tera o salario fixo de R$7.000");
        System.out.println("Digite o nome dele: ");
        nome = scanner.next();

        System.out.println("Digite a experiencia dele (em anos inteiros): ");
        experiencia = leNumeroInteiro();
        tecnico = new Tecnico(nome, 7000, experiencia);

        System.out.println("\nAgora, seu tecnico ira precisar contratar 6 jogadores para o time");        
        for (contador = 0; contador < 6; contador++){
            System.out.println("Digite o nome do " + (contador+1) + "o jogador: ");
            nome = scanner.next(); 

            System.out.println("Digite o salario do " + (contador+1) + "o jogador: ");
            salario = leNumeroDouble(); 

            System.out.println("Digite o numero do " + (contador+1) + "o jogador: ");
            numero = leNumeroInteiro();

            System.out.println("Digite a posicao do " + (contador+1) + "o jogador: ");
            posicao = scanner.next();  

            System.out.println("\n");
            jogador = new Jogador(nome, salario, numero, posicao);
            alJogador.add(jogador);
            folhaSalarial += salario;
        }
        Equipe equipe = new Equipe(alJogador);

        do{
            System.out.println("\n----MENU DE OPCOES----");
			System.out.println("<1> Jogar Partida");
			System.out.println("<2> Pagar Salarios");
            System.out.println("<3> Escalar Time");
            System.out.println("<4> Visualizar Elenco");
            System.out.println("<5> Visualizar Financas");
            System.out.println("<6> Pedir Demissao");
			System.out.println("Sua opcao: ");
            do{
                opcao = leNumeroInteiro(); 
            }while(opcao > 6 || opcao < 0);
            
            
            switch(opcao){
                case 1:
                    resultado = equipe.jogarPartida();
                    switch(resultado){
                        case 0:
                            System.out.println("Derrota! :(");
                            break;
                        case 1:
                            System.out.println("Empate! :|\t+ Valor de meia folha salarial no orcamento!");
                            equipe.atualizaOrcamento(1, folhaSalarial/2);
                            break;
                        case 2:
                            System.out.println("Vitoria! ;)\t+ Valor de uma folha salarial no orcamento!");
                            equipe.atualizaOrcamento(1, folhaSalarial);
                            break;
                        case 3:
                            System.out.println("Escale o time antes!");
                            break;
                        }
                    break;
                case 2:
                    pgtoRealizado = dirigente.pagarSalarios(equipe.getOrcamentoAnual(), folhaSalarial);
                    if(pgtoRealizado){
                        equipe.atualizaOrcamento(2, folhaSalarial);
                        System.out.println("Pagamento efetuado com sucesso!");
                    }else{
                        System.out.println("Saldo insuficiente!");
                        System.out.println("Poxa vida, falimos! :'(\n");
                        status = false;
                    }
                    break;
                case 3:
                    equipe.setEscalada(tecnico.escalarTime());
                    break;
                case 4:
                    System.out.println("ELENCO\nNome\t\t\tNumero\t\t\tPosicao\t\t\tSalario");
                    for (Jogador jog : alJogador) {
                        System.out.println(jog.getNome() + "\t\t\t" + jog.getNumero() + "\t\t\t" + jog.getPosicao() + "\t\t\t" + "R$" + String.format("%.2f", jog.getSalario()));
                    }
                    break;
                case 5:
                    System.out.println("$$$ Orcamento $$$");
                    System.out.println("   R$"+ String.format("%.2f", equipe.getOrcamentoAnual()));
                    break;
                case 6:
                    System.out.println("Voce pediu demissao, obrigado pelo suor entregue em quadra!\n");
                    status = false;
                    break;
            }
        }while(status);
    }
}