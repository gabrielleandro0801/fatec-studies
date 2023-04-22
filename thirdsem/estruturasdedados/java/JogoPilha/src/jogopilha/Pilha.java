package jogopilha;

public class Pilha {
    // Atributos
    private int topo;
    private int dados [];

    // Construtores - com sobrecarga
    public Pilha() {
        dados = new int[10];
        // Iniciando o topo com 0. Ele também poderia ter sido inicializado com -1
        topo = 0;
    }
    
    public Pilha(int capacidade) {
        dados = new int[capacidade];
        topo = 0;
    }

    // Métodos de acesso e modificadores - NÃO HAVERÁ
    
    // Métodos de manipulação básicos da estrutura
    
    // Para verificar se está vazia, basta verificar a posição do topo
    public boolean pilhaVazia() {
        return topo==0?true:false;
        // return topo==0
    }
    
    public boolean pilhaCheia() {
        return topo==dados.length;
        /*if (topo == dados.length) {
            return true;
        }
        return false;*/
    }
    
    public void push(int elemento) {
        dados[topo] = elemento;
        topo++;
    }
    public boolean empilha(int elemento) {
        if (pilhaCheia()) {
            return false;
        }
        dados[topo++] = elemento;
        return true;   
    }
    
    public int pop() {
        topo--;
        return dados[topo];
        // return dados[--topo];
    }
    
    public boolean desempilha(Inteiro inteiro) {
        if (pilhaVazia()) {
            return false;
        }
        inteiro.setInteiro(dados[--topo]);
        return true;
    }
    
    @Override
    public String toString() {
        String s = "";
        for (int i = topo-1; i >= 0; i--) {
            s = s + dados[i] + " ";
        }
        return s;
    }
    
    public int topo() {
        return dados[this.topo-1];
    }
}
