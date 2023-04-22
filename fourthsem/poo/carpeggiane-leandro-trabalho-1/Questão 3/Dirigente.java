public class Dirigente extends Pessoa {

  private String dataInicioMandato;

  public String getDataInicioMandato() {
    return dataInicioMandato;
  }

  public void setDataInicioMandato(String dataInicioMandato) {
    this.dataInicioMandato = dataInicioMandato;
  }

  public Dirigente(String nome, double sal, String dataC) {
    super(nome, sal);
    this.dataInicioMandato = dataC;
  }

  public boolean pagarSalarios(double orcamentoAnual, double folhaSalarial) {
    if (orcamentoAnual >= folhaSalarial) {
      return true;
    }
    return false;
  }
}
