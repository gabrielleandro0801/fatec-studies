package model;

public class Locatario extends Pessoa {

  private int idLocatario;
  private int qtdVagas;

  public int getIdLocatario() {
    return idLocatario;
  }

  public void setIdLocatario(int idLocatario) {
    this.idLocatario = idLocatario;
  }

  public int getQtdVagas() {
    return qtdVagas;
  }

  public void setQtdVagas(int qtdVagas) {
    this.qtdVagas = qtdVagas;
  }

  public Locatario(
    String nome,
    String cpf,
    String dataNasc,
    Long rg,
    int idLocatario,
    int qtdVagas
  ) {
    super(nome, cpf, dataNasc, rg);
    this.idLocatario = idLocatario;
    this.qtdVagas = qtdVagas;
  }

  @Override
  public String toString() {
    return idLocatario + " | " + getNome();
  }
}
