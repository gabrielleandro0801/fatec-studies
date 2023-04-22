package model;

public class Produto {

  private int id;
  private String nome;
  private double preco;
  private String dataValidade;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public String getDataValidade() {
    return dataValidade;
  }

  public void setDataValidade(String dataValidade) {
    this.dataValidade = dataValidade;
  }

  public Produto(int id, String nome, double preco, String dataValidade) {
    this.id = id;
    this.nome = nome;
    this.preco = preco;
    this.dataValidade = dataValidade;
  }

  public Produto() {}
}
