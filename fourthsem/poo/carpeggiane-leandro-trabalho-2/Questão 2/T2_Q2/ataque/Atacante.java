package ataque;

import javax.swing.JOptionPane;
import modelo.*;

public final class Atacante extends Pessoa {

  private String peBom;

  public String getPeBom() {
    return peBom;
  }

  public void setPeBom(String peBom) {
    this.peBom = peBom;
  }

  public Atacante(String nome, int numero, String peBom) {
    super(nome, numero);
    this.peBom = peBom;
  }

  public void jogarBola() {
    JOptionPane.showMessageDialog(
      null,
      getNome() + " finalizando pro gol com o pe " + getPeBom() + "..."
    );
  }
}
