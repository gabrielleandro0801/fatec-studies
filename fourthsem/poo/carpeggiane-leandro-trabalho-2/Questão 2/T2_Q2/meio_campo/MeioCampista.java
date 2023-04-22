package meio_campo;

import javax.swing.JOptionPane;
import modelo.Pessoa;

public final class MeioCampista extends Pessoa {

  private String qualidade;

  public String getQualidade() {
    return qualidade;
  }

  public void setQualidade(String qualidade) {
    this.qualidade = qualidade;
  }

  public MeioCampista(String nome, int numero, String qualidade) {
    super(nome, numero);
    this.qualidade = qualidade;
  }

  public void jogarBola() {
    JOptionPane.showMessageDialog(
      null,
      getNome() +
      " armando as jogadas...\nSua maior qualidade é " +
      getQualidade()
    );
  }
}
