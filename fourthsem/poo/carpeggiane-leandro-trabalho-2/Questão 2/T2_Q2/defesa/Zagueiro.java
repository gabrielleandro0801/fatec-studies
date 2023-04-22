package defesa;

import javax.swing.JOptionPane;
import modelo.Pessoa;

public final class Zagueiro extends Pessoa {

  private double altura;

  public double getAltura() {
    return altura;
  }

  public void setAltura(double altura) {
    this.altura = altura;
  }

  public Zagueiro(String nome, int numero, double altura) {
    super(nome, numero);
    this.altura = altura;
  }

  public void jogarBola() {
    JOptionPane.showMessageDialog(
      null,
      getNome() + " desarmando o adversario..."
    );
  }
}
