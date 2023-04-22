package ex02;

import javax.swing.JOptionPane;

public class Ex02 {

  public static void main(String[] args) {
    String aux;
    int anos, meses, dias, total;
    JOptionPane.showMessageDialog(
      null,
      "Neste programa, informe sua idade em anos, meses e dias separadamente"
    );
    aux = JOptionPane.showInputDialog("Anos:");
    anos = Integer.parseInt(aux);
    aux = JOptionPane.showInputDialog("Meses:");
    meses = Integer.parseInt(aux);
    aux = JOptionPane.showInputDialog("Dias:");
    dias = Integer.parseInt(aux);

    total = dias + meses * 30 + anos * 365;
    JOptionPane.showMessageDialog(null, "Idade total = " + total + " dias");
  }
}
