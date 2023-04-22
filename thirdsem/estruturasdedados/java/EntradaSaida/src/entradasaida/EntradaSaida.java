package entradasaida;

import javax.swing.JOptionPane;

public class EntradaSaida {

  public static void main(String[] args) {
    JOptionPane.showMessageDialog(null, "Hello World");
    String nome;
    nome = JOptionPane.showInputDialog("Digite seu nome!");
    JOptionPane.showMessageDialog(null, "Seu nome é " + nome);
  }
}
