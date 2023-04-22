public class TesteListaPrimUlt {

  public static void main(String[] args) {
    ListaPrimUlt lista = new ListaPrimUlt();
    if (lista.estaVazia()) {
      System.out.println("Lista esta vazia");
    }

    for (int i = 1; i <= 5; i++) {
      lista.insereInicio(i);
      System.out.println(lista);
    }

    System.out.println("\n");

    while (!lista.estaVazia()) {
      System.out.println(lista.removeInicio() + " foi removido do inicio");
      System.out.println(lista);
    }

    System.out.println("\n");
    for (int i = 1; i <= 5; i++) {
      lista.insereFim(i);
      System.out.println(lista);
    }

    System.out.println("\n");
    while (!lista.estaVazia()) {
      System.out.println(lista.removeFim() + " foi removido do final");
      System.out.println(lista);
    }
    System.out.println("\n");
  }
}
