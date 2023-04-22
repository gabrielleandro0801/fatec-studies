package poo04;

public class Disciplina {

  private String nome;
  private String professor;
  private int semestre;
  private boolean ofertada;

  public Disciplina(
    String nome,
    String professor,
    int semestre,
    boolean ofertada
  ) {
    this.nome = nome;
    this.professor = professor;
    this.semestre = semestre;
    this.ofertada = ofertada;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return this.nome;
  }

  public void setProfessor(String professor) {
    this.professor = professor;
  }

  public String getProfessor() {
    return this.professor;
  }

  public void setSemestre(int semestre) {
    this.semestre = semestre;
  }

  public int getSemestre() {
    return this.semestre;
  }

  public void setOfertada(boolean ofertada) {
    this.ofertada = ofertada;
  }

  public boolean getOfertada() {
    return this.ofertada;
  }
}
