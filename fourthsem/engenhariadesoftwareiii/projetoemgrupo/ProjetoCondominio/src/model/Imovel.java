package model;

public class Imovel {

  private int id;
  private int andar;
  private int numero;
  private double tamanho;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getAndar() {
    return andar;
  }

  public void setAndar(int andar) {
    this.andar = andar;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public double getTamanho() {
    return tamanho;
  }

  public void setTamanho(double tamanho) {
    this.tamanho = tamanho;
  }

  public Imovel() {}

  public Imovel(int andar, int numero, double tamanho) {
    this.andar = andar;
    this.numero = numero;
    this.tamanho = tamanho;
  }
}
