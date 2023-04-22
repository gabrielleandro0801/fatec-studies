package comparaordenacao;

import java.util.Date;
import javax.swing.JOptionPane;

public class TesteComparaOrdenacao {

  public static void main(String[] args) {
    // Criando o objeto e o tamanho do vetor
    int t = Integer.parseInt(
      JOptionPane.showInputDialog("Digite o tamanho do vetor")
    );
    ComparaOrdenacao ord = new ComparaOrdenacao(t);

    System.out.println("Vetor de " + t + " posicoes\n");
    // ---------------------BUBBLE---------------------
    // Criando o vetor
    ord.geraVetor();
    System.out.println("Primeiro vetor: " + ord);
    // Ordenando Bubble
    ord.bubbleSort();
    System.out.println("Bubble:         " + ord);

    // ---------------------INSERTION------------------
    ord.geraVetor();
    System.out.println("\nSegundo vetor: " + ord);
    ord.insertionSort();
    System.out.println("Insertion:     " + ord);

    // ---------------------SELECTION------------------
    ord.geraVetor();
    System.out.println("\nTerceiro vetor: " + ord);
    ord.selectionSort();
    System.out.println("Selection:      " + ord);

    // --------------------QUICK SORT------------------
    ord.geraVetor();
    System.out.println("\nQuarto vetor: " + ord);
    ord.quickSort(0, t - 1);
    System.out.println("Quick:        " + ord);
    // Imprimir um objeto sempre imprime o toString() dele
    // JOptionPane.showMessageDialog(null, ord);
  }
}
