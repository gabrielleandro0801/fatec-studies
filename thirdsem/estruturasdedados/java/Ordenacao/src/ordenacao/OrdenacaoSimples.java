package ordenacao;

import java.util.Random;
public class OrdenacaoSimples {
    private int[] v;

    public OrdenacaoSimples(int t) {
        v = new int[t];
    }
    
    public void geraVetor() {
        Random gerador = new Random();
        for (int i = 0; i < v.length; i++) {
            v[i] = gerador.nextInt();
        }
    }
    
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < v.length; i++) {
            s = s + v[i] + " ";
        }
        return s;
    }
    
    public void bubbleSort() {
        int i, j, caixa;
        for (i = 1; i < v.length; i++) {
            for (j = 0; j < v.length - i; j++) {
                if (v[j] > v[j+1]) {
                    caixa = v[j];
                    v[j] = v[j+1];
                    v[j+1] = caixa;
                }
            }
        }
    }
    
    public void insertionSort() {
        int i, j, chave;
        for (i = 1; i < v.length; i++) {
            chave = v[i];
            j = i-1;
            while(j >= 0 && v[j] > chave) {
                v[j+1] = v[j];
                j--;
            }
            v[j+1] = chave;
        }
    }
    
    public void selectionSort() {
        int i, j, menor, posicao = 1, caixa;
        for (i = 0; i < v.length; i++) {
            menor = v[i];
            for (j = i+1; j < v.length; j++) {
                if (v[j] < menor) {
                    menor = v[j];
                    posicao = j;
                }
            }
            if (v[i] > menor) {
                caixa = v[i];
                v[i] = menor;
                v[posicao] = caixa;
            }
        }
        // Ele parte da primeira posição do vetor assumindo que ele seja o menor valor
        // Ele varre o vetor inteiro procurando o menor valor do vetor
        // Caso o menor valor encontrado seja menor que o valor da posição que o índice de vetor indica,
        // É feita a troca entre eles
        // Então o índice aumenta um e é feito o processo de novo
        // O processo é repetido para todas as posições do vetor
    }
    
    public int partition(int p, int r) {
        // i começa do -1
        int i = p-1;
        // x recebe o valor da última posição do vetor
        int x = v[r];
        // aux é uma variável auxiliar
        int aux;
        // a variável j é quem vai varrer o vetor
        for (int j = p; j < r; j++) {
            // caso o valor da posição j seja menor ou igual que o pivô, é feita a troca entre as posições i e j 
            if (v[j] <= x) {
               // i aumenta 1
               i++;
               // é feita a troca
               aux = v[i];
               v[i] = v[j];
               v[j] = aux;
            }
        }
        // ao fim do laço, i incrementa 1
        // o pivô vai pro lugar certo
        i++;
        aux = v[r];
        v[r] = v[i];
        v[i] = aux;
        // é retornada a posição do pivô 
        return i;
    }
    
    public void quickSort(int p, int r) {
        if (p < r) {
            int q = partition(p, r);
            quickSort(p, q-1);
            quickSort(q+1, r);
        }
    }
    
}
