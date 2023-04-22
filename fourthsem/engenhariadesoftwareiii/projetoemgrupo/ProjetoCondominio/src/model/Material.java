package model;

public class Material {

  private int idMaterial;
  private String tipoMaterial;
  private String nomeMaterial;
  private int quantidade;

  public int getIdMaterial() {
    return idMaterial;
  }

  public void setIdMaterial(int idMaterial) {
    this.idMaterial = idMaterial;
  }

  public String getTipoMaterial() {
    return tipoMaterial;
  }

  public void setTipoMaterial(String tipoMaterial) {
    this.tipoMaterial = tipoMaterial;
  }

  public String getNomeMaterial() {
    return nomeMaterial;
  }

  public void setNomeMaterial(String nomeMaterial) {
    this.nomeMaterial = nomeMaterial;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public Material() {}

  public Material(
    int idMaterial,
    String tipoMaterial,
    String nomeMaterial,
    int quantidade
  ) {
    this.idMaterial = idMaterial;
    this.tipoMaterial = tipoMaterial;
    this.nomeMaterial = nomeMaterial;
    this.quantidade = quantidade;
  }

  @Override
  public String toString() {
    return idMaterial + " | " + nomeMaterial;
  }
}
