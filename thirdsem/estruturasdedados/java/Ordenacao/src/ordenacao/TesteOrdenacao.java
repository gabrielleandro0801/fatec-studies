package ordenacao;

import java.util.Date;
import javax.swing.JOptionPane;
public class TesteOrdenacao {
    public static void main(String[] args) {
        // Criando o objeto e o tamanho do vetor
        int t = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho do vetor"));
        OrdenacaoSimples ord = new OrdenacaoSimples(t);
        
        
        System.out.println("Vetor de " + t + " posicoes\n");
        // ---------------------BUBBLE---------------------
        // Criando o vetor
        ord.geraVetor();
        // Criando o objeto Date
        Date dateAntesBubble = new Date();
        System.out.println("Antes do Bubble: " + dateAntesBubble.getTime());
        // Ordenando Bubble
        ord.bubbleSort();
        // Criando o novo objeto
        Date dateDepoisBubble = new Date();
        System.out.println("Depois do Bubble: " + dateDepoisBubble.getTime());
        // Subtraindo os getTime()
        long totalBubble = dateDepoisBubble.getTime() - dateAntesBubble.getTime();
        System.out.println("Tempo de execucao: " + totalBubble);
        
        // ---------------------INSERTION------------------
        ord.geraVetor();
        Date dateAntesInsertion = new Date();
        System.out.println("\nAntes do Insertion: " + dateAntesInsertion.getTime());
        ord.insertionSort();
        Date dateDepoisInsertion = new Date();
        System.out.println("Depois do Insertion: " + dateDepoisInsertion.getTime());
        long totalInsertion = dateDepoisInsertion.getTime() - dateAntesInsertion.getTime();
        System.out.println("Tempo de execucao: " + totalInsertion);
        
        // ---------------------SELECTION------------------
        ord.geraVetor();
        Date dateAntesSelection = new Date();
        System.out.println("\nAntes do Selection: " + dateAntesSelection.getTime());
        ord.selectionSort();
        Date dateDepoisSelection = new Date();
        System.out.println("Depois do Selection: " + dateDepoisSelection.getTime());
        long totalSelection = dateDepoisSelection.getTime() - dateAntesSelection.getTime();
        System.out.println("Tempo de execucao: " + totalSelection);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // Imprimir um objeto sempre imprime o toString() dele
        // JOptionPane.showMessageDialog(null, ord);
    }
}
