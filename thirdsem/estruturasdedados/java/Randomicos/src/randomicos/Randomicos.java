package randomicos;

import java.util.Random;

public class Randomicos {

  public static void main(String[] args) {
    Random geradorRandom = new Random();

    // Gerador de inteiros -- nextInt();
    // Valores do menor inteiro possível ao maior inteiro possível
    int a = geradorRandom.nextInt();
    // Valores até 100
    int b = geradorRandom.nextInt(99);
    System.out.println("a = " + a + "\nb = " + b);

    // Valores reais entre 0 e 1
    double c = geradorRandom.nextDouble();
    System.out.println("c = " + c);
    // Valores reais entre 0 e 10
    double d = geradorRandom.nextDouble() * 10;
    System.out.println("d = " + d);

    // Usando a classe Math
    double e = Math.random();
    System.out.println("e = " + e);
  }
}
