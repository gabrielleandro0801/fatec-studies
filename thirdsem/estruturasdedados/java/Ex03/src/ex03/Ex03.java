package ex03;

import javax.swing.JOptionPane;

public class Ex03 {

  static void par_impar(int a) {
    if (a % 2 == 0) {
      JOptionPane.showMessageDialog(null, a + " é par");
    } else {
      JOptionPane.showMessageDialog(null, a + " é impar");
    }
  }

  static void divisores(int a) {
    int i;
    if (a > 0) {
      for (i = 1; i <= a; i++) {
        if (a % i == 0) {
          JOptionPane.showMessageDialog(null, i + " é divisor de " + a);
        }
      }
    } else {
      for (i = a; i < 0; i++) {
        if (a % i == 0) {
          JOptionPane.showMessageDialog(null, i + " é divisor de " + a);
        }
      }
    }
  }

  public static void main(String[] args) {
    int a;
    String aux;
    aux = JOptionPane.showInputDialog("Informe um número inteiro");
    a = Integer.parseInt(aux);

    par_impar(a);
    divisores(a);
  }
}
