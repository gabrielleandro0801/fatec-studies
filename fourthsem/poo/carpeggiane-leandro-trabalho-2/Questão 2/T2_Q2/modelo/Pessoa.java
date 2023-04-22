package modelo;

public abstract class Pessoa {

  private String nome;
  private int numero;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public Pessoa(String nome, int numero) {
    this.nome = nome;
    this.numero = numero;
  }

  public abstract void jogarBola();
}
