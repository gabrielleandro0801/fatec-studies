package megasena;

import java.util.Random;
public class MegaSena {
    public static void main(String[] args) {
        int[] jogo =  new int[6];
        Random gerador = new Random();
        
        for (int i = 0; i < 6; i++) {
            jogo[i] = gerador.nextInt(60) + 1;
            System.out.println(i+1 + "a posicao: " + jogo[i]);
        }
        
    }
    
}
