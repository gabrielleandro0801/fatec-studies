package poo01;

public class Aluno {

  private String nome;
  private int idade;
  private double peso;
  private boolean formando;
  char sexo;

  public Aluno(String nome, int idade, double peso, char sexo) {
    this.nome = nome;
    this.idade = idade;
    this.peso = peso;
    this.sexo = sexo;
    this.formando = false;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return this.nome;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public int getIdade() {
    return this.idade;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  public double getPeso() {
    return this.peso;
  }

  public void setFormando(boolean formando) {
    this.formando = formando;
  }

  public boolean getFormando() {
    return this.formando;
  }

  public void setSexo(char sexo) {
    this.sexo = sexo;
  }

  public char getSexo() {
    return this.sexo;
  }
}
