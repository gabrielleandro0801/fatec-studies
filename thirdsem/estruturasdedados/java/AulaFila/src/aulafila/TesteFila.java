package aulafila;

public class TesteFila {
    // criar um metodo que recebe 2 filas de tamanhos iguais e faz o merge dela
    // devolvendo a fila resultante
    static Fila mergeFila(Fila f1, Fila f2){
        int capacidade = (f1.getCapacidade() + f2.getCapacidade());
        Fila f3 = new Fila(capacidade);
        
        int i;
        while(!f1.filaVazia()){
            f3.insereFila(f1.removeFila());
            f3.insereFila(f2.removeFila());
        }
        
        return f3;
    }
    
    public static void main(String args[]){
        Fila fila = new Fila(12);
        
        int i = 1;
        while(!fila.filaCheia()){
            fila.insereFila(i++);
            System.out.println(fila);
        }
        
        System.out.println("\n");
        
        while(!fila.filaVazia()){
            System.out.println(fila.removeFila() + " foi atendido");
            System.out.println(fila);
        }
        
        
        Fila f1 = new Fila(6);
        Fila f2 = new Fila(6);
        
        for(i = 1; i < 6; i+= 2){
            f1.insereFila(i);
        }
        System.out.println("\nf1: " + f1);
        for(i = 2; i <= 6; i+=2){
            f2.insereFila(i);
        }
        System.out.println("f2: " + f2);
        
        Fila f3 = mergeFila(f1, f2);
        System.out.println("f3: " + f3);
        
     
    }
}
