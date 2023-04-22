package testerecursao;

public class TesteRecursao {

  static int fat(int n) {
    if (n == 1 || n == 0) {
      return 1;
    }
    return n * fat(n - 1);
  }

  static int fib(int n) {
    if (n == 1 || n == 0) {
      return 1;
    }
    return fib(n - 2) + fib(n - 1);
  }

  public static void main(String[] args) {
    for (int i = 0; i <= 41; i++) {
      System.out.println("Fib de " + i + ": " + fib(i));
    }
  }
}
