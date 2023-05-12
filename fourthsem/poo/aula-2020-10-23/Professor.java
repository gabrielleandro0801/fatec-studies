public class Professor {

  private String codProf;
  private String nomeProf;

  public Professor() {
    codProf = "";
    nomeProf = "";
  }

  public Professor(String codigo, String nome) {
    this.codProf = codigo;
    this.nomeProf = nome;
  }

  public String getCodProf() {
    return codProf;
  }

  public void setCodProf(String codProf) {
    this.codProf = codProf;
  }

  public String getNomeProf() {
    return nomeProf;
  }

  public void setNomeProf(String nomeProf) {
    this.nomeProf = nomeProf;
  }

  public String toString() {
    return codProf + " - " + nomeProf;
  }

  public boolean equals(Object obj) {
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    if (this == obj) return true;

    final Professor other = (Professor) obj;
    if (codProf == null && other.codProf != null) return false;
    if (codProf != null && other.codProf == null) return false;
    if (!codProf.equals(other.codProf)) return false;
    return true;
  }

  public int hashCode() {
    return 31 + ((nomeProf == null) ? 0 : nomeProf.hashCode());
  }
}
