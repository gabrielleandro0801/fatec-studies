package model;

public class Pessoa {

  private String nome;
  private String cpf;
  private String dataNasc;
  private Long rg;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getDataNasc() {
    return dataNasc;
  }

  public void setDataNasc(String dataNasc) {
    this.dataNasc = dataNasc;
  }

  public Long getRg() {
    return rg;
  }

  public void setRg(Long rg) {
    this.rg = rg;
  }

  public Pessoa(String nome, String cpf, String dataNasc, Long rg) {
    this.nome = nome;
    this.cpf = cpf;
    this.dataNasc = dataNasc;
    this.rg = rg;
  }

  public Pessoa() {}
}
