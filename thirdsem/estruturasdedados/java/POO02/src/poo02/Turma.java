// package poo02;

public class Turma {

  private String nome;
  private String curso;
  private int quantidadeDeAlunos;
  private int serie;

  public Turma(String nome, String curso, int quantidadeDeAlunos, int serie) {
    this.nome = nome;
    this.curso = curso;
    this.quantidadeDeAlunos = quantidadeDeAlunos;
    this.serie = serie;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return this.nome;
  }

  public void setCurso(String curso) {
    this.curso = curso;
  }

  public String getCurso() {
    return this.curso;
  }

  public void setQuantidadeDeAlunos(int quantidadeDeAlunos) {
    this.quantidadeDeAlunos = quantidadeDeAlunos;
  }

  public int getQuantidadeDeAlunos() {
    return this.quantidadeDeAlunos;
  }

  public void setSerie(int serie) {
    this.serie = serie;
  }

  public int getSerie() {
    return this.serie;
  }
}
