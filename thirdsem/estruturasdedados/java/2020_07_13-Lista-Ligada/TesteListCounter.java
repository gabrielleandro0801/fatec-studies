public class TesteListCounter {

  public static void main(String[] args) {
    ListCounter lista = new ListCounter();
    if (lista.estaVazia()) {
      System.out.println("Lista esta vazia");
    }

    System.out.println("-------------INSERINDO NO INICIO-------------");
    for (int i = 1; i <= 10; i++) {
      lista.insereInicio(i);
      System.out.println(lista);
      System.out.println("Contador: " + lista.getContador() + "\n");
    }
    System.out.println("-------------REMOVENDO DO FINAL-------------");
    while (!lista.estaVazia()) {
      System.out.println(lista.removeFim() + " foi removido do final");
      System.out.println(lista);
      System.out.println("Contador: " + lista.getContador() + "\n");
    }

    System.out.println("-------------INSERINDO NO FINAL-------------");
    for (int i = 1; i <= 7; i++) {
      lista.insereFim(i);
      System.out.println(lista);
      System.out.println("Contador: " + lista.getContador() + "\n");
    }

    System.out.println("-------------REMOVENDO DO INICIO-------------");
    while (!lista.estaVazia()) {
      System.out.println(lista.removeInicio() + " foi removido do inicio");
      System.out.println(lista);
      System.out.println("Contador: " + lista.getContador() + "\n");
    }
  }
}
