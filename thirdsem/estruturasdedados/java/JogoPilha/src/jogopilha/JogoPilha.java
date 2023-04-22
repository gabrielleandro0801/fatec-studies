package jogopilha;

import java.util.Random;
public class JogoPilha {
    public static void main(String[] args) {
        Pilha p = new Pilha(10);
        Random gerador = new Random();
        
        do{
            // Esse jogada vai ser 0 ou 1
            int jogada = gerador.nextInt(2);
            if (jogada == 1) {
                int valor = gerador.nextInt(10);
                if (!p.pilhaCheia()) {
                    p.push(valor);
                    System.out.print(valor + " empilhado: ");
                    // System.out.println("Topo: " + p.topo());
                } else {
                    System.out.println("Tentou empilhar: ");
                }
            } else {
                if (!p.pilhaVazia()) {
                    System.out.print(p.pop() + " foi desempilhado: ");
                    if (p.pilhaVazia()) {
                        System.out.print("Pilha vazia, game over!");
                    }
                } else {
                    System.out.print("Pilha vazia, game over!");
                }
            }
            System.out.println(p);
        }while(!p.pilhaVazia());
    }
    
    // Só se mexe na estrutura através dos métodos dela
    
}
