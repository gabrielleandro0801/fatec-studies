package pilha;

// GRUPO:
// Alexandre Souza Rocha
// Gabriel Leandro Santos Sousa
// Matheus Carpeggiane Montenegro da Silva

public class Pilha {

  // Atributos
  private int topo;
  private int dados[];

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
    return topo == 0 ? true : false;
    // return topo==0
  }

  public boolean pilhaCheia() {
    return topo == dados.length;
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
    for (int i = topo - 1; i >= 0; i--) {
      s = s + dados[i] + " ";
    }
    return s;
  }

  public int copiaPilha(Pilha copia) {
    int quantidadeCopiada = 0;
    for (int i = 0; i < topo; i++) {
      copia.push(this.dados[i]);
      quantidadeCopiada++;
    }
    return quantidadeCopiada;
  }

  public int transferePilha(Pilha destino) {
    int quantidadeCopiada = 0;
    while (!this.pilhaVazia() && !destino.pilhaCheia()) {
      destino.push(this.pop());
      quantidadeCopiada++;
    }
    return quantidadeCopiada;
  }

  @Override
  public boolean equals(Object objeto) {
    // Verifica se o parametro é um objeto do tipo Pilha
    if (!(objeto instanceof Pilha)) {
      return false;
    }

    // Copia o parametro para a instância copia, que é do tipo Pilha
    Pilha copia = (Pilha) objeto;

    // Verifica se os topos são iguais
    if (!(this.topo == copia.topo)) {
      return false;
    }

    // Verifica se todos os elementos delas são iguais
    for (int i = topo - 1; i >= 0; i--) {
      if (!(this.dados[i] == copia.dados[i])) {
        return false;
      }
    }
    return true;
  }
}
