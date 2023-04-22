import java.util.ArrayList;

public class Partido {

  private String nome_partido;
  private String sigla;
  private ArrayList<Candidato> candidatos;

  public String getNome_partido() {
    return nome_partido;
  }

  public void setNome_partido(String nome_partido) {
    this.nome_partido = nome_partido;
  }

  public String getSigla() {
    return sigla;
  }

  public void setSigla(String sigla) {
    this.sigla = sigla;
  }

  public ArrayList<Candidato> getCandidatos() {
    return candidatos;
  }

  public void setCandidatos(ArrayList<Candidato> candidatos) {
    this.candidatos = candidatos;
  }

  public Partido(
    String nome_partido,
    String sigla,
    ArrayList<Candidato> candidatos
  ) {
    this.nome_partido = nome_partido;
    this.sigla = sigla;
    this.candidatos = candidatos;
  }

  public Partido() {}
}
