public class Curso {

  private String codCurso;
  private String nomeCurso;
  private String cargaHorariaCurso;

  public String getCodCurso() {
    return codCurso;
  }

  public void setCodCurso(String codCurso) {
    this.codCurso = codCurso;
  }

  public String getNomeCurso() {
    return nomeCurso;
  }

  public void setNomeCurso(String nomeCurso) {
    this.nomeCurso = nomeCurso;
  }

  public String getCargaHorariaCurso() {
    return cargaHorariaCurso;
  }

  public void setCargaHorariaCurso(String cargaHorariaCurso) {
    this.cargaHorariaCurso = cargaHorariaCurso;
  }

  public String toString() {
    return codCurso + " - " + nomeCurso + " - " + cargaHorariaCurso;
  }

  public boolean equals(Object obj) {
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    if (this == obj) return true;

    final Curso other = (Curso) obj;
    if (codCurso == null && other.codCurso != null) return false;
    if (codCurso != null && other.codCurso == null) return false;
    if (!codCurso.equals(other.codCurso)) return false;
    return true;
  }

  public int hashCode() {
    return 31 + ((nomeCurso == null) ? 0 : nomeCurso.hashCode());
  }
}
