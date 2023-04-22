package aulafila;

public class Fila {

  private int dados[];
  private int prim;
  private int ult;
  private int capacidade;
  // contador vai servir pra ver a quantidade de elementos na fila
  private int contador;

  public Fila() {
    dados = new int[10];
    prim = 0;
    ult = 0;
    capacidade = 10;
    contador = 0;
  }

  // Construtor com o usuario decidindo o tamanho do vetor
  public Fila(int capacidade) {
    dados = new int[capacidade];
    prim = 0;
    ult = 0;
    this.capacidade = capacidade;
    contador = 0;
  }

  int proxima(int posicao) {
    return (posicao + 1) % capacidade;
  }

  int anterior(int posicao) {
    return (posicao + capacidade - 1) % capacidade;
  }

  public boolean filaVazia() {
    return (contador == 0);
  }

  public boolean filaCheia() {
    return (contador == this.capacidade);
  }

  public void insereFila(int valor) {
    dados[this.ult] = valor;
    this.ult = proxima(ult);
    contador++;
  }

  public int removeFila() {
    // primeiro voce deixa o valor guardado no elemento, faz as operacoes e so depois retorna o elemento
    int elemento = dados[this.prim];
    this.prim = proxima(prim);
    contador--;
    return elemento;
  }

  public int consultaPrimeiro() {
    return this.dados[prim];
  }

  public int consultaUltimo() {
    return (dados[anterior(ult)]);
  }

  @Override
  public String toString() {
    String s = "";
    if (filaVazia()) {
      s += " fila vazia";
    } else {
      int i = prim;
      do {
        s += dados[i] + " ";
        i = proxima(i);
      } while (i != ult);
    }
    return s;
  }

  public int getCapacidade() {
    return this.capacidade;
  }

  public int getTamanho() {
    return this.contador;
  }
}
