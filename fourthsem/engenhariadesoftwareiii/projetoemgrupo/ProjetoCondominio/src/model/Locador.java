package model;

public class Locador extends Pessoa {

  private int idLocador;
  private String dataAquisicaoImovel;

  public int getIdLocador() {
    return idLocador;
  }

  public void setIdLocador(int idLocador) {
    this.idLocador = idLocador;
  }

  public String getDataAquisicaoImovel() {
    return dataAquisicaoImovel;
  }

  public void setDataAquisicaoImovel(String dataAquisicaoImovel) {
    this.dataAquisicaoImovel = dataAquisicaoImovel;
  }

  public Locador() {}

  public Locador(
    String nome,
    String cpf,
    String dataNasc,
    Long rg,
    int idLocador,
    String dataAquisicaoImovel
  ) {
    super(nome, cpf, dataNasc, rg);
    this.idLocador = idLocador;
    this.dataAquisicaoImovel = dataAquisicaoImovel;
  }

  @Override
  public String toString() {
    return idLocador + " | " + getNome();
  }
}
