package pilha;

// GRUPO:
// Alexandre Souza Rocha
// Gabriel Leandro Santos Sousa
// Matheus Carpeggiane Montenegro da Silva

public class TestePilha {

  public static void main(String[] args) {
    Pilha p1 = new Pilha();

    Pilha p2 = new Pilha(6);

    // p3 para ter os mesmos dados da p1
    Pilha p3 = new Pilha();

    // Insercao na pilha 1, com push e com teste de pilha cheia
    int i = 10;
    while (!p1.pilhaCheia()) {
      p1.push(i);
      // Tornando a pilha p3 igual a p1
      p3.push(i++);
    }

    // Criando a pilha p4 para uso de transferencia
    Pilha p4 = new Pilha();
    System.out.println("\nP1 e P3 sao iguais aqui? " + p1.equals(p3) + "");
    System.out.println(
      "Pilha P1 sendo transferida para P4... Qtd transferida: " +
      p1.transferePilha(p4)
    );
    System.out.println("P1: " + p1 + " (o que sobrou)");
    System.out.println("P4: " + p4 + " (transferida)");
    System.out.println("P1 e P3 sao iguais agora? " + p1.equals(p3) + "\n");

    while (!p1.pilhaVazia()) {
      System.out.println(p1.pop() + " foi desempilhado!");
    }

    // Inserção na pilha 2, deixando o teste para o empilha
    int j = 1;
    while (p2.empilha(j++));
    Inteiro inteiro = new Inteiro();
    int soma = 0;

    while (p2.desempilha(inteiro)) {
      System.out.println(inteiro.getInteiro() + " foi desempilhado");
      soma += inteiro.getInteiro();
    }
  }
}
