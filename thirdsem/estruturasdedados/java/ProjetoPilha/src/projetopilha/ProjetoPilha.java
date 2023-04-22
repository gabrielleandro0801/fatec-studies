// package projetopilha;

// GRUPO:
// Alexandre Souza Rocha
// Gabriel Leandro Santos Sousa
// Matheus Carpeggiane Montenegro da Silva

import javax.swing.JOptionPane;

public class ProjetoPilha {

  public static void main(String[] args) {
    // Criando uma pilha de tamanho 100
    Pilha pilha = new Pilha(100);

    // Recebendo o valor a ser convertido
    int numero;
    do {
      numero =
        Integer.parseInt(
          JOptionPane.showInputDialog("Informe um numero inteiro positivo")
        );
    } while (numero <= 0);
    System.out.printf("Numero desejado: " + numero);

    // Convertendo para binario
    int resto;
    while (numero != 0) {
      System.out.println("\nNum: " + numero + "/2");
      resto = numero % 2;
      System.out.println("Resto: " + resto + " -> push (" + resto + ")");
      numero /= 2;
      System.out.println("Num: " + numero);
      // Empilhando o resto (0 ou 1)
      pilha.push(resto);
    }

    // Imprimido a pilha partindo do topo
    System.out.println("\nPilha: " + pilha);
  }
}
