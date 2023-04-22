package model;

public class Visitante extends Pessoa {

  private int idVisitante;
  private String motivo;

  public int getIdVisitante() {
    return idVisitante;
  }

  public void setIdVisitante(int idVisitante) {
    this.idVisitante = idVisitante;
  }

  public String getMotivo() {
    return motivo;
  }

  public void setMotivo(String motivo) {
    this.motivo = motivo;
  }

  public Visitante() {}

  public Visitante(
    String nome,
    String cpf,
    String dataNasc,
    Long rg,
    int idVisitante,
    String motivo
  ) {
    super(nome, cpf, dataNasc, rg);
    this.idVisitante = idVisitante;
    this.motivo = motivo;
  }

  @Override
  public String toString() {
    return idVisitante + " | " + this.getNome();
  }
}
