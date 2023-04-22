package circulo;

import javax.swing.JOptionPane;

// Ler o valor de um raio (positivo), calcular e mostrar o comprimento da circunferência, a área do círculo e o volume da esfera correspondentes
public class Circulo { // 2*PI*raio

  static double calcComprimento(double raio) {
    return 2 * Math.PI * raio;
  }

  static double calcArea(double raio) {
    return Math.PI * Math.pow(raio, 2);
  }

  static double calcVolume(double raio) {
    return (double) (4 * Math.PI * Math.pow(raio, 3)) / 3;
  }

  public static void main(String[] args) {
    double raio;
    do {
      raio =
        Double.parseDouble(
          JOptionPane.showInputDialog("Digite um raio maior que 0")
        );
    } while (raio <= 0);
    double comprimento = calcComprimento(raio);
    double area = calcArea(raio);
    double volume = calcVolume(raio);
    JOptionPane.showMessageDialog(
      null,
      "Valor do comprimento = " +
      String.format("%.3f", comprimento) +
      "\nValor da area = " +
      String.format("%.3f", area) +
      "\nValor do volume = " +
      String.format("%.3f", volume)
    );
  }
}
